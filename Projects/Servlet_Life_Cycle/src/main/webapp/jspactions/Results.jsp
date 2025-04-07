<%
    int grades = 73;
    String result = "";

    if (grades > 75) {
        result = "Distinction";
    }

    else if (grades > 60) {
        result = "First Class";
    }

    else if (grades > 50) {
        result = "Second Class";
    }

    else if (grades > 35) {
        result = "Pass";
    }

    else {
        result = "Fail";
    }

    out.println(result);

%>
