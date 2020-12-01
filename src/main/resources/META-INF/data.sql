INSERT INTO recruiter(email,name,password,phone) VALUES ("mgmg@gmail.com","mgmg","123","0995336536");
INSERT INTO recruiter(email,name,password,phone) VALUES ("aungaung@gmail.com","aungaung","123","0995556686");

INSERT INTO township(name) VALUES ("Yangon");
INSERT INTO township(name) VALUES ("Mandalay");
INSERT INTO township(name) VALUES ("Naypyitaw");

INSERT INTO ava(id,description) VALUES ("1","immediately");
INSERT INTO ava(id,description) VALUES ("2","1 week");
INSERT INTO ava(id,description) VALUES ("3","2 week");
INSERT INTO ava(id,description) VALUES ("4","1 or 2 month");

INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("100","added");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("200","contected");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("300","qualifying");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("400","submitted");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("500","first interviewing");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("600","offered");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("700","client declined");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("800","placed");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("900","second interview");
INSERT INTO candidatejoborderstatus(id,short_description) VALUES ("1000","third interview");

INSERT INTO candidate (`email`, `entry_date`, `expectedSalary`, `is_active`, `key_skills`, `name`, `phone`, `ava`, `entryBy`, `township`,`cv_form`) VALUES ('mgmg@gmail.com', '2020-11-26', '300000', 'yes', 'JAVA, PHP', 'Mg Mg', '0987653456', '1', '1', '2','a.pdf');
INSERT INTO candidate (`email`, `entry_date`, `expectedSalary`, `is_active`, `key_skills`,  `name`, `phone`, `ava`, `entryBy`, `township`,`cv_form`) VALUES ('aungaung@gmail.com', '2020-11-26', '400000', 'yes', 'Python', 'Aung Aung', '0965345668', '2', '1', '1','b.pdf');
INSERT INTO candidate (`email`, `entry_date`, `expectedSalary`, `is_active`, `key_skills`, `name`, `phone`, `ava`, `entryBy`, `township`,`cv_form`) VALUES ('tuntun@gmail.com', '2020-11-26', '500000', 'yes', 'C++', 'Tun Tun', '09345678765', '3', '1', '3','c.pdf');

