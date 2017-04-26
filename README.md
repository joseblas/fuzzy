# Goal
 Show how to scale fuzzy computation in Apache Spark.
 
# how to run 

 ## Start DSE
```
  docker run --name dse-bdec2 -d -p 7077:7077 -p 7080:7080 -p 7081:7081 -p 9042:9042 -p 8182:8182 -p 8983:8983 -p 4040:4040 -p 4041:4041 luketillman/datastax-enterprise:5.0.7 -g -k -s
```
 ## Run the App
  ```
  sbt run 
  ```
  
  and chose 
   ```
  [3] fuzzy.http.Main
  ```
  ## Send json with post
   url: http://localhost:8888/matching
   json:
   ```javascript
      {
       "kb": "3i,Aberdeen Asset Management,Admiral Group,Anglo American plc,Antofagasta,ARM Holdings,Ashtead Group,Associated British Foods,AstraZeneca,Aviva,Babcock International,BAE Systems,Barclays,Barratt Developments,Berkeley Group Holdings,BHP Billiton,BP,British American Tobacco plc,British Land,BT Group,Bunzl,Burberry,Capita,Carnival Corporation & plc,Centrica,Coca-Cola HBC AG,Compass Group,CRH plc,DCC plc,Diageo,Direct Line Group,Dixons Carphone,EasyJet,Experian,Fresnillo plc,GKN,GlaxoSmithKline,Glencore,Hammerson,Hargreaves Lansdown,Hikma Pharmaceuticals,HSBC,Imperial Brands,Inmarsat,InterContinental Hotels Group,International Consolidated Airlines Group SA,Intertek,Intu Properties,ITV plc,Johnson Matthey,Kingfisher plc,Land Securities,Legal & General,Lloyds Banking Group,London Stock Exchange Group,London School Economics,Marks & Spencer,Merlin Entertainments,Mondi,National Grid plc,Next plc,Old Mutual,Pearson PLC,Persimmon plc,Provident Financial,Prudential plc,Randgold Resources,Reckitt Benckiser,RELX Group,Rexam,Rio Tinto Group,Rolls-Royce Holdings,Royal Bank of Scotland Group,Royal Dutch Shell,Royal Mail,RSA Insurance Group,SABMiller,Sage Group,Sainsbury's,Schroders,Severn Trent,Shire plc,Sky plc,Smith & Nephew,Smiths Group,Sports Direct,SSE plc,Standard Chartered,Standard Life,St. James's Place plc,Taylor Wimpey,Tesco,Travis Perkins,TUI Group,Unilever,United Utilities,Vodafone Group,Whitbread,Wolseley plc,Worldpay,WPP plc,JT Coder Limited",
       "data": "3i,Aberdeen Asset Management,Admiral Group,British Petroleum,BAT,BAE,Barratt,Direct Line,LSE,RBS,BT,CocaCola,Jonson Mathey,Sports Drect,Tesco,Sky,JT Coder Ltd,GSK"
      }
   ```
      
# How to check Apache Spark UI (docker)
 
 [master http://localhost:7080](http://localhost:7080)
  
 [slave http://localhost:7081](http://localhost:7081) 