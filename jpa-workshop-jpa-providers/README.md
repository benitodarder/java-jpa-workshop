# jpa-workshop-jpa-providers

Sample console application to retrieve data from a sample database, to show 
how to use different JPA providers.

To change the provider:

* Update the content of persistence.xml with the corresponding sample
* Update the content of pom.xml with the correspondig sample accordingly with the persistence.xml content

Sample launch command for Hsqldb:

* java -cp c:\Programs\hsqldb\hsqldb-2.5.1\hsqldb\lib\hsqldb.jar org.hsqldb.Server -silent false -database.0 file:D:\Development\databases\hsqldb\2.5.1\products\products.db -dbname.0 products
