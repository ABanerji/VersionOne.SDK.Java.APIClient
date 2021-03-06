package com.versionone.apiclient.tests;

import com.versionone.apiclient.IAssetType;
import com.versionone.apiclient.IMetaModel;
import com.versionone.apiclient.MetaException;
import com.versionone.apiclient.MetaModel;

public abstract class ServicesTesterBase {
	
	protected abstract String getServicesTestKeys();	
	protected boolean preload() {return false;}
	
	private IMetaModel _meta;
	
	protected IMetaModel getMeta() {
		if (_meta == null)
			_meta = new MetaModel(new ResponseConnector.XMLResponseConnector(MetaTesterBase.TEST_DATA,"meta.v1/",getServicesTestKeys()), preload());
		return _meta;
	}
	
	private ResponseConnector.XMLResponseConnector _dataConnector;
	ResponseConnector getDataConnector() {
			if(_dataConnector == null)
				_dataConnector = new ResponseConnector.XMLResponseConnector(MetaTesterBase.TEST_DATA, "rest-1.v1/", getServicesTestKeys());
			return _dataConnector;
	}

	protected IAssetType getAssetType(String token) throws MetaException
	{
		return getMeta().getAssetType(token);
	}
}
