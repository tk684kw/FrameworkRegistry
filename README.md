# FrameworkRegistry
CREATE TABLE framework (  
&nbsp;&nbsp;id int(11) NOT NULL AUTO_INCREMENT,  
&nbsp;&nbsp;name varchar(45) NOT NULL,  
&nbsp;&nbsp;version varchar(45) NOT NULL,  
&nbsp;&nbsp;deprecation_date date NOT NULL,  
&nbsp;&nbsp;hype_level int(11) NOT NULL,  
&nbsp;&nbsp;PRIMARY KEY (id)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
