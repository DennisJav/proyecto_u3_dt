package com.uce.ec.service.funcional.deber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class ConsumerImpl implements IConsumer<Alumno>{
	public static final Logger LOG = LogManager.getLogger(ConsumerImpl.class);

	@Override
	public void accept(Alumno arg1) {
		// TODO Auto-generated method stub
		LOG.info("Consumer : "+arg1.toString());
	}

}
