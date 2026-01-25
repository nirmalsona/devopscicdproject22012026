package com.devops;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {
    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {

            String response = """
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Happy Republic Day</title>
                    <style>
                        body {
                            margin: 0;
                            height: 100vh;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            font-family: Arial, sans-serif;
                            background: linear-gradient(to bottom, 
                                #FF9933 33%, 
                                white 33%, white 66%, 
                                #138808 66%);
                        }
                        .content {
                            text-align: center;
                        }
                        h1 {
                            color: navy;
                            font-size: 48px;
                        }
                        h2 {
                            color: #000080;
                        }
                        .chakra {
                            font-size: 60px;
                        }
                    </style>
                </head>
                <body>
                    <div class="content">
                        <div class="chakra">🇮🇳</div>
                        <h1>Happy Republic Day</h1>
                        <h2>26th January</h2>
                        <p>
                            DevOps CI/CD Project<br>
                            By Nirmal Shanker & Sona Dwivedi
                        </p>
                    </div>
                </body>
                </html>
                """;

            exchange.getResponseHeaders().set("Content-Type", "text/html");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Web server started on port 8080");
    }
}

