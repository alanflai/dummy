package com.alanflai.dummy;

 //=======================================================================
 // Copyright (c) 2020 Andrea Sorrente
 //
 // This program is free software: you can redistribute it and/or modify
 // it under the terms of the GNU General Public License as published by
 // the Free Software Foundation, either version 3 of the License, or
 // (at your option) any later version.
 //
 // This program is distributed in the hope that it will be useful,
 // but WITHOUT ANY WARRANTY; without even the implied warranty of
 // MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 // GNU General Public License for more details.
 //
 // You should have received a copy of the GNU General Public License
 // along with this program.  If not, see <http://www.gnu.org/licenses/>.
 //========================================================================
 
 /*
 * jettyserver
 * 
 * The http/servelet server embedded into the java app.
 * It uses the jetty framwork.
 * 
 * Jetty slogan:
 * "Don’t deploy your application in Jetty, deploy Jetty in your application!"
 */

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


public class jettyserver {

    public static Server createServer(int port) {

        // Server creation
        Server server =  new Server(port);

        // Server handlers association
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        
      
        // Servlet and relative url pate association to handler
        handler.addServletWithMapping(HelloServlet.class, "/*");

        return server;
    }

}