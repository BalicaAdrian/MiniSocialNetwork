<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 6/3/2019
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserDescription</title>
</head>
<body>
<%
    //GET THE VALUE FROM SIGNUPJSP EMAIL
    String email = (String)request.getAttribute("email");
    String userName=(String)request.getAttribute("userName");
    String userSurname=(String)request.getAttribute("userSurname");
    int id= (Integer)request.getAttribute("idOfPerson");

    //CREATEE A PARAMETER FOR SERVLET

    request.getSession().setAttribute("ID",id);
    request.getSession().setAttribute("Email", email);
    request.getSession().setAttribute("userName", userName);
    request.getSession().setAttribute("userSurname", userSurname);

    ;%>



<form action="/SignUpForm_war_exploded/userProfileDescription" id="UserDescription" method="post">
    Gender:
    <input type="radio" name="Gender" value="Male"> Male
    <input type="radio" name="Gender" value="Female"> Female
    <input type="radio" name="Gender" value="Other" required> Other

    <br>


<select name="Location" form="UserDescription">
    <option value="Alba">Alba</option>
    <option value="Arad">Arad</option>
    <option value="Arges">Arges</option>
    <option value="Bacau">Bacau</option>
    <option value="Bihor">Bihor</option>
    <option value="Bistrita-Nasaud">Bistrita-Nasaud</option>
    <option value="Botosani">Botosani</option>
    <option value="Brasov">Brasov</option>
    <option value="Braila">Braila</option>
    <option value="Buzau">Buzau</option>
    <option value="Caraș-Severin">Caraș-Severin</option>
    <option value="Calarasi">Calarasi</option>
    <option value="Cluj">Cluj</option>
    <option value="Constanta">Constanta</option>
    <option value="Covasna">Covasna</option>
    <option value="Dambovita">Dambovita</option>
    <option value="Dolj">Dolj</option>
    <option value="Galati">Galati</option>
    <option value="Giurgiu">Giurgiu</option>
    <option value="Gorj">Gorj</option>
    <option value="Harghita">Harghita</option>
    <option value="Hunedoara">Hunedoara</option>
    <option value="Ialomita">Ialomita</option>
    <option value="Iasi">Iasi</option>
    <option value="Ilfov">Ilfov</option>
    <option value="Maramures">Maramures</option>
    <option value="Mehedinti">Mehedinti</option>
    <option value="Mures">Mures</option>
    <option value="Neamț">Neamț</option>
    <option value="Olt">Olt</option>
    <option value="Prahova">Prahova</option>
    <option value="Satu Mare">Satu Mare</option>
    <option value="Salaj">Salaj</option>
    <option value="Sibiu">Sibiu</option>
    <option value="Suceava">Suceava</option>
    <option value="Teleorman">Teleorman</option>
    <option value="Timis">Timis</option>
    <option value="Tulcea">Tulcea</option>
    <option value="Vaslui">Vaslui</option>
    <option value="Valcea">Valcea</option>
    <option value="Vrancea">Vrancea</option>
    <option value="Municipiul Bucuresti">Municipiul Bucuresti</option>

</select>

    <br>
    Description:<br>
    <textarea rows="4" cols="50" name="comment" form="UserDescription">
Enter text here...</textarea>

    <br>
<div>
    Day      Month     Year <br>

    <select name='day' >
        <option value='1'>1</option>
        <option value='2'>2</option>
        <option value='3'>3</option>
        <option value='4'>4</option>
        <option value='5'>5</option>
        <option value='6'>6</option>
        <option value='7'>7</option>
        <option value='8'>8</option>
        <option value='9'>9</option>
        <option value='10'>10</option>
        <option value='11'>11</option>
        <option value='12'>12</option>
        <option value='13'>13</option>
        <option value='14'>14</option>
        <option value='15'>15</option>
        <option value='16'>16</option>
        <option value='17'>17</option>
        <option value='18'>18</option>
        <option value='19'>19</option>
        <option value='20'>20</option>
        <option value='21'>21</option>
        <option value='22'>22</option>
        <option value='23'>23</option>
        <option value='24'>24</option>
        <option value='25'>25</option>
        <option value='26'>26</option>
        <option value='27'>27</option>
        <option value='28'>28</option>
        <option value='29'>29</option>
        <option value='30'>30</option>
        <option value='31'>31</option>
    </select>


    <select name='month' >
        <option value='1'>1</option>
        <option value='2'>2</option>
        <option value='3'>3</option>
        <option value='4'>4</option>
        <option value='5'>5</option>
        <option value='6'>6</option>
        <option value='7'>7</option>
        <option value='8'>8</option>
        <option value='9'>9</option>
        <option value='10'>10</option>
        <option value='11'>11</option>
        <option value='12'>12</option>
    </select>


    <select name='year' >
        <option value='1947'>1947</option>
        <option value='1948'>1948</option>
        <option value='1949'>1949</option>
        <option value='1950'>1950</option>
        <option value='1951'>1951</option>
        <option value='1952'>1952</option>
        <option value='1953'>1953</option>
        <option value='1954'>1954</option>
        <option value='1955'>1955</option>
        <option value='1956'>1956</option>
        <option value='1957'>1957</option>
        <option value='1958'>1958</option>
        <option value='1959'>1959</option>
        <option value='1960'>1960</option>
        <option value='1961'>1961</option>
        <option value='1962'>1962</option>
        <option value='1963'>1963</option>
        <option value='1964'>1964</option>
        <option value='1965'>1965</option>
        <option value='1966'>1966</option>
        <option value='1967'>1967</option>
        <option value='1968'>1968</option>
        <option value='1969'>1969</option>
        <option value='1970'>1970</option>
        <option value='1971'>1971</option>
        <option value='1972'>1972</option>
        <option value='1973'>1973</option>
        <option value='1974'>1974</option>
        <option value='1975'>1975</option>
        <option value='1976'>1976</option>
        <option value='1977'>1977</option>
        <option value='1978'>1978</option>
        <option value='1979'>1979</option>
        <option value='1980'>1980</option>
        <option value='1981'>1981</option>
        <option value='1982'>1982</option>
        <option value='1983'>1983</option>
        <option value='1984'>1984</option>
        <option value='1985'>1985</option>
        <option value='1986'>1986</option>
        <option value='1987'>1987</option>
        <option value='1988'>1988</option>
        <option value='1989'>1989</option>
        <option value='1990'>1990</option>
        <option value='1991'>1991</option>
        <option value='1992'>1992</option>
        <option value='1993'>1993</option>
        <option value='1994'>1994</option>
        <option value='1995'>1995</option>
        <option value='1996'>1996</option>
        <option value='1997'>1997</option>
        <option value='1998'>1998</option>
        <option value='1999'>1999</option>
        <option value='2000'>2000</option>
        <option value='2001'>2001</option>
        <option value='2002'>2002</option>
        <option value='2003'>2003</option>
        <option value='2004'>2004</option>
        <option value='2005'>2005</option>
        <option value='2006'>2006</option>
        <option value='2007'>2007</option>
        <option value='2008'>2008</option>
        <option value='2009'>2009</option>
        <option value='2010'>2010</option>
        <option value='2011'>2011</option>
        <option value='2012'>2012</option>
        <option value='2013'>2013</option>
        <option value='2014'>2014</option>
        <option value='2015'>2015</option>
        <option value='2016'>2016</option>
        <option value='2017'>2017</option>
        <option value='2018'>2018</option>
    </select>

</div>


<br>
<br>
<input type="submit">
</form>
</body>
</html>
