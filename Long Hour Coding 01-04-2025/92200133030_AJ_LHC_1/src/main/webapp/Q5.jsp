    <%@ page import="java.util.List" %>
    <%@ page import="LHC_92200133030.services.Batch_Services" %>
    <%@ page import="LHC_92200133030.models.batch" %>
    <%@ page import="LHC_92200133030.services.Process_Services" %>
    <%@ page import="LHC_92200133030.models.process" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <html>
    <head>
        <title>View Blogs</title>
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>

    <div class="container">
        <h1>All Batch</h1>

        <!-- Blog Table -->
        <table>
            <thead>
            <tr>
                <th>Batch Id</th>
                <th>No of Products</th>
                <th>Product Name</th>
                <th>Batch Name</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <%
                Batch_Services bs = new Batch_Services();
                List<batch> batches = bs.getAllBatch();

                for (batch b : batches) {
            %>
            <tr>
                <td><%= b.getBatch_id() %></td>
                <td><%= b.getNo_of_product() %></td>
                <td><%= b.getProduct_name() %></td>
                <td><%= b.getBatch_name() %></td>
                <td><%= b.getStatus() %></td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>

        <table>
                <thead>
                <tr>
                    <th>Process Id</th>
                    <th>Process Name</th>
                </tr>
                </thead>
                <tbody>
                <%
                    Process_Services ps = new Process_Services();
                    List<process> processes = ps.getAllProcess();

                    for (process p : processes) {
                %>
                <tr>
                    <td><%= p.getProcess_id()%></td>
                    <td><%= p.getProcess_name() %></td>

                </tr>
                <%
                    }
                %>
                </tbody>
            </table>

        <div class="button-container">
            <button onclick="print_report()">Print Report</button>
        </div>
    </div>

    <script>

    function print_report() {
        window.print();
    }
    </script>

    </body>
    </html>
