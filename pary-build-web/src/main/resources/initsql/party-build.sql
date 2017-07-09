Insert into T_AUT_OPERATOR
   (OPERATOR_ID, USERNAME, USERNAME_CN, USER_PASSWORD)
 Values
   ('1001', 'test', '测试账号', '123456');

Insert into T_AUT_PERMISSION
   (PERM_ID, PERM_NAME, RESOUCE)
 Values
   ('1', 'test_perm_1', '/');
Insert into T_AUT_PERMISSION
   (PERM_ID, PERM_NAME, RESOUCE)
 Values
   ('2', 'test_perm_2', '/test');
Insert into T_AUT_PERMISSION
   (PERM_ID, PERM_NAME, RESOUCE)
 Values
   ('3', 'test_perm_3', '/hello');

Insert into T_AUT_ROLE
   (ROLE_ID, ROLE_NAME)
 Values
   ('1', '管理员');
Insert into T_AUT_ROLE
   (ROLE_ID, ROLE_NAME)
 Values
   ('2', '录入员');

   Insert into T_AUT_ROLE_PERMISSION
   (ROLE_ID, PERMISSION_ID)
 Values
   ('1', '1');
Insert into T_AUT_ROLE_PERMISSION
   (ROLE_ID, PERMISSION_ID)
 Values
   ('1', '2');
Insert into T_AUT_ROLE_PERMISSION
   (ROLE_ID, PERMISSION_ID)
 Values
   ('2', '2');
Insert into T_AUT_ROLE_PERMISSION
   (ROLE_ID, PERMISSION_ID)
 Values
   ('2', '3');

Insert into T_AUT_USER_ROLE
   (OPERATOR_ID, ROLE_ID)
 Values
   ('10001', '1');
Insert into T_AUT_USER_ROLE
   (OPERATOR_ID, ROLE_ID)
 Values
   ('10001', '2');
Insert into T_AUT_USER_ROLE
   (OPERATOR_ID, ROLE_ID)
 Values
   ('1001', '2');
Insert into T_AUT_USER_ROLE
   (OPERATOR_ID, ROLE_ID)
 Values
   ('1001', '1');
COMMIT;



