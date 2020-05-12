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
 
/**
 * App
 * 
 * Rel. 1.0.0
 * 
 * Calendario dell'anno, per ogni giorno del mese determina
 * e stampa il giorno della settimana.
 **/

 
import java.util.Calendar;
import java.util.Date;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


public class App 
{
    public static jettyserver server;
    public static void main( String[] args ) throws Exception {

        int port;

        System.out.println( "******************* Calendario 2020 ****************" );

        if(args[0] != null){
            port = Integer.parseInt(args[0]);
        }
        else {
            port = 8085;
        }
        
        server = new jettyserver(port);
        
        server.start();

        // 2020 Year Months
        /*

        Month oMonth = new Month();
        
        for(int i=0; i < 12; i++){

            System.out.println("Mese: " + Month.MONTH_LIST[i]);
            oMonth.list(2020,i+1);
        }
        */

    }
}
