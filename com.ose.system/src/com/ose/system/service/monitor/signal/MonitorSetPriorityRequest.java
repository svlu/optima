/* COPYRIGHT-ENEA-SRC-R2 *
 **************************************************************************
 * Copyright (C) 2008 by Enea Software AB.
 * All rights reserved.
 *
 * This Software is furnished under a software license agreement and
 * may be used only in accordance with the terms of such agreement.
 * Any other use or reproduction is prohibited. No title to and
 * ownership of the Software is hereby transferred.
 *
 * PROPRIETARY NOTICE
 * This Software consists of confidential information.
 * Trade secret law and copyright law protect this Software.
 * The above notice of copyright on this Software does not indicate
 * any actual or intended publication of such Software.
 **************************************************************************
 * COPYRIGHT-END */

package com.ose.system.service.monitor.signal;

import java.io.IOException;
import com.ose.gateway.Signal;
import com.ose.gateway.SignalInputStream;
import com.ose.gateway.SignalOutputStream;

public class MonitorSetPriorityRequest extends Signal
{
   public static final int SIG_NO = 39089;

   public int pid;      // U32
   public int priority; // U32

   public MonitorSetPriorityRequest()
   {
      super(SIG_NO);
   }

   public MonitorSetPriorityRequest(int pid, int priority)
   {
      super(SIG_NO);
      this.pid = pid;
      this.priority = priority;
   }

   protected void read(SignalInputStream in) throws IOException
   {
      pid = in.readS32();
      priority = in.readS32();
   }

   protected void write(SignalOutputStream out) throws IOException
   {
      out.writeS32(pid);
      out.writeS32(priority);
   }
}
