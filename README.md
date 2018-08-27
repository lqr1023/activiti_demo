## activiti cloud   https://activiti.gitbook.io/activiti-7-developers-guide/components-architecture/overview
### overview  
activiti cloud 提供了支持整个平台的基本服务和仅限于BPM的服务，所有的服务之间可以进行解耦，你可以自由的重新整合或替代服务。  
下列是已开发的服务：  
- Activiti Cloud Infrastructure  
-- Activiti Cloud Gateway   
-- Activiti Cloud Registry   
-- Activiti Cloud Single Sign On (SSO)  
-- Activiti Cloud Identity Management (IDM)  
-- Activiti Cloud Configuration Server  
-- Activiti Cloud Logging   
-- Storage / Databases   
-- Message Brokers    
- Activiti Cloud Applications  
-- Activiti Cloud Query Service   
-- Activiti Cloud Audit Service   
-- Activiti Cloud Notification Service  
-- Activiti Cloud Runtime Bundles  
-- Activiti Cloud Connectors  
定义了需要由基础框架提供的服务，这意味着在不同的环境中这些组件可以被其他的基础服务所替代。其他的组件需要依赖于这些服务来正常工作  
![框架](img/pic1.png)  
Activiti Cloud 是动态的并且可以配置到运行环境中,我们使用运行组件来定义应用的使用的范围，这些组件提供了进程的运行时和业务运行时（和版本）的自动化。 
从这个流程来看,我们需要有两种不同的运行组件来进行业务流程的转化 。  
每一个AC组件都要去定义把进程的状态存储到什么地方。这需要很灵活的配置去支持大范围的脚本文件,并且需要去定义整体架构怎么去运行。为了简化设置了默认值。  
### Spring Cloud & Activiti Cloud  
从Activiti的框架来看主要依赖于Spring Boot/Cloud的3个基本方面来更好的继承剩余的组件。 
- Spring Boot HATEOAS 支持所有的REST返回值  
- Spring Cloud 确保可以异步地执行和产生事件，这确保了解耦的独立组件之间可以相互协作。  
- 抽象层面如 Service Registry, Gateway,Distributed Configuration Service  
确保Activiti可以正确地在分布式环境如Docker和Kubernetes中运行。  
### Activiti Cloud Infrastructure  
- 网关 Gateway  
Activiti应用是由一系列需要被结合到一起的组件组成的。使用Netflix Zuul 来连接 Eureka，基于注册到Eureka上的服务创建动态的路径 
- 注册 Registry  
平台上的服务需要进行注册，在Docker组件里依赖于Netflix Eureka 来动态地注册服务。
- 单点登录 Single Sign On（SSO）  
单点登录确保连接者具有权限访问服务。默认使用 Keycloak 作为SSO服务的提供者，Keycloak支持OAuth2, Kerberos 和 SAML的集成,我们使用了OAuth2方法。通过使用 Keycloak提供了其他社交平台(Facebook, Google, etc.) 来进行登录。  
- 身份管理 Identity Management   
跟大多数BPM解决方案一样，我们需要集成任务&进程和定义在组织里的用户,分组，角色之间的关系。我们使用Keycloak作为SSO和身份管理层。Keycloak集成了很多系统如客户的数据库，LDAP, Active Directory 和Social Logins  
### Configuration Service  
分布式Log  Distributed Logging   
- Spring Boot Kubernetes https://github.com/Activiti/example-runtime-bundle/blob/develop/src/main/resources/logback-spring.xml
- json log https://github.com/logstash/logstash-logback-encoder  
### 快速开始  
- 创建和启动一个Maven项目：  
创建一个名为


