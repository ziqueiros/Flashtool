package org.system;

import linuxlib.DeviceChangedListenerLinux;
import win32lib.DeviceChangedListenerWin32;

public class DeviceChangedListener {
	
	static DeviceChangedListenerWin32 lwin32=null;
	static DeviceChangedListenerLinux llinux=null;
	
	public DeviceChangedListener() {
		if (OS.getName().equals("windows")) {
			lwin32 = new DeviceChangedListenerWin32();
		}
		else {
			llinux = new DeviceChangedListenerLinux();
		}
	}
	
	public static void start() {
		if (OS.getName().equals("windows")) {
			lwin32 = new DeviceChangedListenerWin32();
		}
		else {
			llinux = new DeviceChangedListenerLinux();
		}		
	}
	
	public static void stop() {
		if (OS.getName().equals("windows")) {
			if (lwin32!=null)
				lwin32.usbwatch.end();
		}
		else {
			if (llinux!=null)
				llinux.usbwatch.end();
		}
	}
	
	public static void pause(boolean paused) {
		if (OS.getName().equals("windows")) {
			if (lwin32!=null)
				lwin32.usbwatch.pause(paused);
		}
		else {
			if (llinux!=null)
				llinux.usbwatch.pause(paused);
		}
	}

}