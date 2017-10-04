package com.sau.designpattern.structural.proxy.remoteproxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReportGenerator extends Remote{
	
	public String generateDailyReport() throws RemoteException;

}
