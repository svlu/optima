/* COPYRIGHT-ENEA-SRC-R2 *
 **************************************************************************
 * Copyright (C) 2005-2007 by Enea Software AB.
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

public class MonitorGetMemory64Request extends Signal
{
   public static final int SIG_NO = 40829;

   public int pid;     // U32
   public long address; // U64
   public int size;    // U32

   public MonitorGetMemory64Request()
   {
      super(SIG_NO);
   }

   public MonitorGetMemory64Request(int pid, long address, int size)
   {
      super(SIG_NO);
      this.pid = pid;
      this.address = address;
      this.size = size;
   }

   protected void read(SignalInputStream in) throws IOException
   {
      pid = in.readS32();
      address = in.readS64();
      size = in.readS32();
      in.readS32(); // Unused U32 reserved0
      in.readS64(); // Unused U64 reserved1
   }

   protected void write(SignalOutputStream out) throws IOException
   {
      out.writeS32(pid);
      out.writeS64(address);
      out.writeS32(size);
      out.writeS32(0); // Unused U32 reserved0
      out.writeS64(0); // Unused U64 reserved1
   }
}
