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

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AppTest {

    private static int port = 8091;

    private static jettyserver server;

    @BeforeClass
    public static void setup() throws Exception {
       try {
          server = new jettyserver(port);
          server.start();
       }
       catch(Exception err){
           System.out.println("Errore: " + err.toString());
       }

    }

    @AfterClass
    public static void cleanup() throws Exception {
        try {
            server.stop();
         }
         catch(Exception err){
             System.out.println("Errore: " + err.toString());
         }
    }


    @Test
    public void checkReturnStatusOK() throws Exception {

        String url = "http://localhost:".concat(Integer.toString(this.port)).concat("/");
        System.out.println("Test url: " + url);
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        // then
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);

    }

    @Test
    public void checkBodyResponse() throws Exception {

        String url = "http://localhost:".concat(Integer.toString(this.port)).concat("/");
        System.out.println("Test url: " + url);
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);

        // then
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(200);
        String responseContent = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
        assertThat(responseContent).contains("[OK]");

    }

}