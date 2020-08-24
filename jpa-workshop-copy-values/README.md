# jpa-workshop-copy-values

A colleague needed a sample application to verify how to copy values from one table/entity to another in JPA when using an hierarchical model.
This model is based in an existing one and pending to apply some improvements.

	Base:
	 -> MasterFromBase
	 -> SecondaryFromBase
	 
This project also shows how not all providers implement all JPA required features in the same way. 

* About hierarchical model: https://docs.oracle.com/javaee/7/api/javax/persistence/DiscriminatorColumn.html

* Hibernate do not require a DiscriminatorColumn
	
* EclipseLink requires DiscriminatorColumn
	
As the model does not implement the DiscriminatorColumn can only be run with Hibernate, getting the following error with EclipseLink:

```
Internal Exception: java.sql.SQLSyntaxErrorException: user lacks privilege or object not found: T0.DTYPE
Error Code: -5501
Call: SELECT t0.ID, t0.DTYPE, t0.COMMONVALUE, t0.enabled, t0.name, t1.ID, t1.VALUE01, t1.VALUE02, t1.VALUE03 FROM BASE t0, MASTER_FROM_BASE t1 WHERE ((t1.ID = t0.ID) AND (t0.DTYPE = ?))
	bind => [1 parameter bound]
Query: ReadAllQuery(referenceClass=MasterFromBase sql="SELECT t0.ID, t0.DTYPE, t0.COMMONVALUE, t0.enabled, t0.name, t1.ID, t1.VALUE01, t1.VALUE02, t1.VALUE03 FROM BASE t0, MASTER_FROM_BASE t1 WHERE ((t1.ID = t0.ID) AND (t0.DTYPE = ?))")
```

Schemas for Hsqldb provided.



