# auto-complete-service

This service has been implemented using Spring boot. The below are pre reqs
1. Java 8
2. Maven
3. Access to internet (to contact maven central)

# This implementation uses Radix Trie(Compressed Radix Tree) algorithm which is efficient for prefix search. This can be implemented more efficiently for larger datasets using Elastic searches.

Execution steps

1. check out/clone the code 
2. go to the auto-complete-service folder
3. type mvn clean install
4. type mvn spring-boot:run

Try like below to get city suggestions:
http://localhost:8080/suggest_cities?start=hyd&atmost=3


