package com.lastminute.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lastminute.dao.LastminuteDao;
import com.lastminute.dao.impl.LastminuteDaoImpl;
import com.lastminute.exception.DAOException;
import com.lastminute.model.ItemI;
import com.lastminute.model.ItemOutputI;
import com.lastminute.model.OrderI;
import com.lastminute.model.OrderOutputI;
import com.lastminute.model.TaxI;
import com.lastminute.model.impl.Info;
import com.lastminute.model.impl.ItemInputImpl;
import com.lastminute.model.impl.ItemOutputImpl;
import com.lastminute.model.impl.OrderOutputImpl;
import com.lastminute.model.impl.TaxImpl;
import com.lastminute.service.LastminuteService;


@Service
public class LastminuteServiceImpl implements LastminuteService {

	static final Logger log = Logger.getLogger(LastminuteServiceImpl.class);

	@Autowired
	LastminuteDao lastminuteDao;

	@Override
	public OrderOutputI processLastMinuteOrder(OrderI orderI) {
		log.info("ServiceImpl lOrder " + orderI);

		OrderOutputI o = new OrderOutputImpl(orderI);

		ObjectMapper mapper = new ObjectMapper();
		TaxI taxI = null;
		float basicTaxTotal = 0;
		float impTaxTotal = 0;
		float priceTotal = 0;

		try {

			if (lastminuteDao == null) {
				lastminuteDao = new LastminuteDaoImpl();	//instance from junit
				taxI = lastminuteDao.getTaxProduct();
			} else {
				//just instance from autowired context
				taxI = lastminuteDao.getTaxProduct();
			}

			List<ItemInputImpl> listItem = mapper.convertValue(o.getItems(), new TypeReference<List<ItemInputImpl>>() {});

			List<ItemOutputImpl> listItemToSet = new ArrayList<>();

			for (ItemInputImpl item : listItem) {

				float basicTax = 0;
				float impTax = 0;
				boolean isExcept = false;

				for (int i = 0; i < taxI.getExceptProducts().size(); i++) {
					ItemInputImpl xxx = (ItemInputImpl) taxI.getExceptProducts().get(i);
					String typeTax = xxx.getType();

					if (typeTax.equals(item.getType())) {
						isExcept = true;
						break;
					}
				}

				if (!isExcept) {
					basicTax = item.getQuantity() * item.getPrice() * taxI.getBasicSalesTax() / 100;
				}

				if (item.isImported()) {
					impTax = item.getQuantity() * item.getPrice() * taxI.getImportTax() / 100;
				}

				priceTotal = priceTotal + item.getQuantity() * item.getPrice();
				basicTaxTotal = basicTaxTotal + round05(basicTax);
				impTaxTotal = impTaxTotal + round05(impTax);

				float tax = round05(basicTax) + round05(impTax);

				ItemOutputImpl oI = new ItemOutputImpl(item.getQuantity(), item.getType(), item.getPrice() + tax, tax);

				listItemToSet.add(oI);
			}

			o.setItems(listItemToSet);
			o.setSalesTaxes(basicTaxTotal + impTaxTotal);
			o.setTotal(round2Decimal(priceTotal) + basicTaxTotal + impTaxTotal);

			log.info("ServiceImpl Output - " + o.toString());

		} catch (DAOException eD) {
			log.info("DAOException " + eD.getMessage());
			o.setItems(null);
			o.setSalesTaxes(0);
			Info info = new Info();
			info.setKey("ERROR");
			info.setValue(eD.getMessage());
			List<Info> listI = new ArrayList<>();
			listI.add(info);
			o.setInfos(listI);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("DAOException " + e.getMessage());
			o.setItems(null);
			o.setSalesTaxes(0);
			Info info = new Info();
			info.setKey("ERROR");
			info.setValue(e.getMessage());
			List<Info> listI = new ArrayList<>();
			listI.add(info);
			o.setInfos(listI);
		}
		return o;
	}

	public static float round05(float num) {
		return (float) (Math.ceil(num * 20) / 20.0);
	}

	public static float round2Decimal(float num) {
		return (float) (Math.round(num * 100.0) / 100.0);
	}
}
