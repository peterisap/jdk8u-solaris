/*
 * Portions Copyright 2006 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */
package com.sun.xml.internal.ws.transport.local.server;
import java.security.Principal;
import com.sun.xml.internal.ws.spi.runtime.WebServiceContext;
import javax.xml.ws.handler.MessageContext;


public class LocalWSContextImpl implements WebServiceContext  {

    public static ThreadLocal msgContext = new ThreadLocal();

    public MessageContext getMessageContext() {
        MessageContext ctxt = (MessageContext)msgContext.get();
        if (ctxt == null) {
            throw new IllegalStateException();
        }
        return ctxt;
    }

    public void setMessageContext(MessageContext ctxt) {
        msgContext.set(ctxt);
    }

    public Principal getUserPrincipal() {
        return null;
    }


    public boolean isUserInRole(String role) {
        return false;
    }

}