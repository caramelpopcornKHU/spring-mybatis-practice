# 표준적인 Spring MVC 프로젝트 파일 구조   
src/main/java   
====================   
ㄴlx.edu.springmvc   
or      
ㄴcom.lx.myapp   
===================   
## ㄴconfig/   
DatabaseConfig.java  
SecurityConfig.java  
WebConfig.java   
## ㄴcontroller/   
UserController.java  
ProductController.java  
AddrBookController.java   
## ㄴservice/   
UserService.java  
OrderService.java  
## ㄴrepository/ or dao/    
UserRepository.java  
ProductRepository.java  
AddrBookDAO.java   
## ㄴdomain/ or model/ or vo/ or dto/  <-db와 직접 매핑되는 객체  
User.java  
UserDto.java  
AddressVO.java  
AddrbookVO.java   
## MyappApplication.java // 애플리케이션 시작점   

====================
# src/main/resources  
└── mappers/  
UserMapper.xml     // <-- XML 파일  
mapper-addrbook.xml  
mapper-emp.xml   

====================
====================
src/main/webapp/WEB-INF/views
====================
## ㄴ jsp파일들