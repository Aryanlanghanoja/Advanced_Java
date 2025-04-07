<%
    String btn = request.getParameter("btnSubmit");

    if (btn != null) {

        int num1 = Integer.parseInt(request.getParameter("txtFirstNum").equals("") ? "0" : request.getParameter("txtFirstNum"));
        int num2 = Integer.parseInt(request.getParameter("txtSecondNum").equals("") ? "0" : request.getParameter("txtSecondNum"));
        String opt = request.getParameter("operation");

        switch(opt) {
            case "+" :
                out.print(num1 + " + "+ num2 + " = " + (num1 + num2));
                break;
            case "-" :
                 out.print(num1 + " - "+ num2 + " = " + (num1 - num2));
                 break;
            case "*" :
                 out.print(num1 + " * "+ num2 + " = " + (num1 * num2));
                 break;
            case "/" :

                if (num2 == 0) {
                    out.print("Cannot Divide By Zero");
                }

                else {
                     out.print(num1 + " / "+ num2 + " = " + (num1 / num2));
                }

                 break;

            case "%" :
                 out.print(num1 + " % "+ num2 + " = " + (num1 % num2));
                 break;
            default:
                 out.print("Invalid Operation");
                 break;
        }

    }

    else {
        out.print("Enter the Data From Input File");
    }



%>