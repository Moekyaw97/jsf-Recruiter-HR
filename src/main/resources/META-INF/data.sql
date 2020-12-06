INSERT INTO recruiter(email,name,password,phone) VALUES ("mgmg@gmail.com","mgmg","123","0995336536");
INSERT INTO recruiter(email,name,password,phone) VALUES ("aungaung@gmail.com","aungaung","123","0995556686");

INSERT INTO township(name) VALUES ("Yangon");
INSERT INTO township(name) VALUES ("Mandalay");
INSERT INTO township(name) VALUES ("Naypyitaw");

INSERT INTO ava(id,description) VALUES ("1","immediately");
INSERT INTO ava(id,description) VALUES ("2","1 week");
INSERT INTO ava(id,description) VALUES ("3","2 week");
INSERT INTO ava(id,description) VALUES ("4","1 or 2 month");

INSERT INTO company (`address`, `email`, `entry_date`, `ishot`, `name`, `ownerName`, `phone1`, `phone2`, `remark`, `website`, `entryBy`, `township`) VALUES ('MTP Condo', 'mmit@gmail.com', '2020-11-26', 'yes', 'MMIT', 'YY', '095674565', '095646787', 'asdf', 'mmit@gmail.com', '1', '1');
INSERT INTO company (`address`, `email`, `entry_date`, `ishot`, `name`, `ownerName`, `phone1`, `phone2`, `remark`, `website`, `entryBy`, `township`) VALUES ('MTP Condo', 'myanit@gmail.com', '2020-11-26', 'yes', 'MyanmarIT', 'SS', '0945675445', '095566789', 'asdf', 'myanmar@gmail.com', '1', '2');


INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('100', 'Added');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('200', 'Interview Request');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('300', 'Interview Accept');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('400', 'Interview Reject');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('500', 'First Interview');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('600', 'Second Interview');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('700', 'Third Interview');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('800', 'Offered');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('900', 'Placed');
INSERT INTO candidateJoborderStatus  (`id`,`short_description`) VALUES ('1000', 'Candidate Declined');

INSERT INTO candidate (`email`, `entry_date`, `expectedSalary`, `is_active`, `key_skills`, `name`, `phone`, `ava`, `entryBy`, `township`,`cv_form`) VALUES ('mgmg@gmail.com', '2020-11-26', '300000', 'yes', 'JAVA, PHP', 'Mg Mg', '0987653456', '1', '1', '2','a.pdf');
INSERT INTO candidate (`email`, `entry_date`, `expectedSalary`, `is_active`, `key_skills`,  `name`, `phone`, `ava`, `entryBy`, `township`,`cv_form`) VALUES ('aungaung@gmail.com', '2020-11-26', '400000', 'yes', 'Python', 'Aung Aung', '0965345668', '2', '1', '1','b.pdf');
INSERT INTO candidate (`email`, `entry_date`, `expectedSalary`, `is_active`, `key_skills`, `name`, `phone`, `ava`, `entryBy`, `township`,`cv_form`) VALUES ('tuntun@gmail.com', '2020-11-26', '500000', 'yes', 'C++', 'Tun Tun', '09345678765', '3', '1', '3','c.pdf');

INSERT INTO joborder (`basic_salary`, `entry_date`, `is_active`, `job_description`, `job_position`, `total_employee`, `companyId`, `entryBy`, `job_location`) VALUES ('600000', '2020-11-23', 'yes', 'Description', 'Backend Developer', '2', '1', '1', '1');
INSERT INTO joborder (`basic_salary`, `entry_date`, `is_active`, `job_description`, `job_position`, `total_employee`, `companyId`, `entryBy`, `job_location`) VALUES ('500000', '2020-11-24', 'yes', 'Description', 'Frontend Developer', '2', '2', '1', '2');
INSERT INTO joborder (`basic_salary`, `entry_date`, `is_active`, `job_description`, `job_position`, `total_employee`, `companyId`, `entryBy`, `job_location`) VALUES ('400000', '2020-11-23', 'yes', 'Description', 'HR', '3', '1', '1', '1');

INSERT INTO candidate_job_order (`entry_date`, `candidate_id`, `candidatejoborderstatus_id`, `entryBy`, `joborder_id`) VALUES ('2020-11-24', '1', '100', '1', '1');
INSERT INTO candidate_job_order (`entry_date`, `candidate_id`, `candidatejoborderstatus_id`, `entryBy`, `joborder_id`) VALUES ('2020-11-24', '2', '100', '2', '1');
INSERT INTO candidate_job_order (`entry_date`, `candidate_id`, `candidatejoborderstatus_id`, `entryBy`, `joborder_id`) VALUES ('2020-11-25', '2', '100', '1', '3');
INSERT INTO candidate_job_order (`entry_date`, `candidate_id`, `candidatejoborderstatus_id`, `entryBy`, `joborder_id`) VALUES ('2020-11-24', '1', '100', '2', '2');
INSERT INTO candidate_job_order (`entry_date`, `candidate_id`, `candidatejoborderstatus_id`, `entryBy`, `joborder_id`) VALUES ('2020-11-26', '3', '100', '1', '1');


