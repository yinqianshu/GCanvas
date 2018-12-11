/**
 * Created by G-Canvas Open Source Team.
 * Copyright (c) 2017, Alibaba, Inc. All rights reserved.
 *
 * This source code is licensed under the Apache Licence 2.0.
 * For the full copyright and license information, please view
 * the LICENSE file in the root directory of this source tree.
 */
package com.taobao.gcanvas.util;

import android.util.Log;

import com.taobao.gcanvas.GCanvasJNI;

public class GLog {

	public static final String TAG = "CANVAS";

	public static final int LEVEL_FORCE = 0;
	public static final int LEVEL_VERBOSE = 2;
	public static final int LEVEL_DEBUG = 3;
	public static final int LEVEL_INFO = 4;
	public static final int LEVEL_WARN = 5;
	public static final int LEVEL_ERROR = 6;
	public static final int LEVEL_ASSERT = 7;
	public static final int LEVEL_NULL = 9;

	public static int logLevel = LEVEL_INFO;

	public static IGLogger customLog = null;

	public static void setCustomLogImpl(IGLogger log) {
		customLog = log;
	}

	public static void setLevel(String level) {
		if (level == null) {
			return;
		}

		if (level.equals("force")) {
			logLevel = LEVEL_FORCE;
		}else if (level.equals("debug")) {
			logLevel = LEVEL_DEBUG;
		}else if (level.equals("info")) {
			logLevel = LEVEL_INFO;
		}else if (level.equals("warn")) {
			logLevel = LEVEL_WARN;
		}else if (level.equals("error")) {
			logLevel = LEVEL_ERROR;
		}else if (level.equals("fatal")) {
			logLevel = LEVEL_ASSERT;
		}

		GCanvasJNI.setLogLevel(level);
	}

	public static int getLevel() {
		return logLevel;
	}

	public static void force(String Tag, String message) {
		eInner(Tag, message);
	}

	public static void i(String message) {
		iInner(TAG, message);
	}

	public static void i(String Tag, String message) {
		if (logLevel == LEVEL_FORCE) {
			GLog.force(Tag, message);
		} else if (logLevel <= LEVEL_INFO) {
			iInner(Tag, message);
		}
	}


	public static void i(String Tag, String message, Throwable e) {
		if (logLevel <= LEVEL_INFO) {
			iInner(Tag, message, e);
		}
	}

	private static void iInner(String tag, String message) {
		if (customLog != null) {
			customLog.i(tag, message);
		} else {
			Log.i(tag, message);
		}
	}

	private static void iInner(String tag, String message, Throwable e) {
		if (customLog != null) {
			customLog.i(tag, message, e);
		} else {
			Log.i(tag, message, e);
		}
	}


	public static void d(String message) {
		GLog.d(TAG, message);
	}

	public static void d(String Tag, String message) {
		if (logLevel == LEVEL_FORCE) {
			GLog.force(Tag, message);
		} else if (logLevel <= LEVEL_DEBUG) {
			dInner(Tag, message);
		}
	}

	public static void d(String Tag, String message, Throwable e) {
		if (logLevel <= LEVEL_DEBUG) {
			dInner(Tag, message, e);
		}
	}

	private static void dInner(String tag, String message) {
		if (customLog != null) {
			customLog.d(tag, message);
		} else {
			Log.d(tag, message);
		}
	}

	private static void dInner(String tag, String message, Throwable e) {
		if (customLog != null) {
			customLog.d(tag, message, e);
		} else {
			Log.d(tag, message, e);
		}
	}

	public static void e(String message) {
		GLog.e(TAG, message);
	}

	public static void e(String Tag, String message) {
		if (logLevel <= LEVEL_ERROR) {
			eInner(Tag, message);
		}
	}

	public static void e(String Tag, String message, Throwable e) {
		if (logLevel <= LEVEL_ERROR) {
			eInner(Tag, message, e);
		}
	}

	private static void eInner(String tag, String message) {
		if (customLog != null) {
			customLog.e(tag, message);
		} else {
			Log.e(tag, message);
		}
	}

	private static void eInner(String tag, String message, Throwable e) {
		if (customLog != null) {
			customLog.e(tag, message, e);
		} else {
			Log.e(tag, message, e);
		}
	}


	public static void w(String message) {
		GLog.w(TAG, message);
	}

	public static void w(String Tag, String message) {
		if (logLevel == LEVEL_FORCE) {
			GLog.force(Tag, message);
		} else if (logLevel <= LEVEL_WARN) {
			wInner(Tag, message);
		}
	}

	public static void w(String Tag, String message, Throwable e) {
		if (logLevel <= LEVEL_WARN) {
			wInner(Tag, message, e);
		}
	}

	private static void wInner(String tag, String message) {
		if (customLog != null) {
			customLog.w(tag, message);
		} else {
			Log.w(tag, message);
		}
	}

	private static void wInner(String tag, String message, Throwable e) {
		if (customLog != null) {
			customLog.w(tag, message, e);
		} else {
			Log.w(tag, message, e);
		}
	}

	public static void v(String message) {
		GLog.v(TAG, message);
	}

	public static void v(String Tag, String message) {
		if (logLevel == LEVEL_FORCE) {
			GLog.force(Tag, message);
		} else if (logLevel <= LEVEL_VERBOSE) {
			vInner(Tag, message);
		}
	}

	public static void v(String Tag, String message, Throwable e) {
		if (logLevel <= LEVEL_VERBOSE) {
			vInner(Tag, message, e);
		}
	}

	private static void vInner(String tag, String message) {
		if (customLog != null) {
			customLog.v(tag, message);
		} else {
			Log.v(tag, message);
		}
	}

	private static void vInner(String tag, String message, Throwable e) {
		if (customLog != null) {
			customLog.v(tag, message, e);
		} else {
			Log.v(tag, message, e);
		}
	}

}