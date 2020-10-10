# Követelmény specifikáció


### Jelenlegi helyzet leírása (Tamás)
  

---


### Vágyálomrendszer leírása (Tamás)


---


### Jelenlegi üzleti folyamatok (Ádám)


---


### Igényelt üzleti folyamatok (Dóra)

1. A számológépen belül többfajta számológép, illetve konvertáló legyen elérhető:
    1. Alap (Basic) számológép:
        * Támogasson alap matematikai műveleteket
            - Az alapműveletek a numerikus billentyűzet közvetlen közelében legyenek
        * Támogasson haladó matematikai koncepciókat 
            - Konverziók, trigonometriai függvények, híres konstansok ...
            - A funkciók típus szerint csoportosítva legyenek, a műveletek könnyebb megtalálása érdekében
    2. Haladó (Advanced) számológép:
        * Kinézetre hasonló vagy ugyanolyan is lehet mint az alap számológép
        * Támogasson alap matematikai műveleteket
            - Az alapműveletek a numerikus billentyűzet közvetlen közelében legyenek
        * Támogasson haladó matematikai koncepciókat 
            - Konverziók, trigonometriai függvények, híres konstansok...
            - A funkciók típus szerint csoportosítva legyenek, a műveletek könnyebb megtalálása érdekében
        * Támogassa matematikai kifejezések megadását
            - Legyenek zárojelezésre alkalmas gombok, melyek segítenek a kifejezések megadásában
            - A számológép tudja kezelni a kijezéseket
            - A számológép ismerje a műveletek helyes kiértékelési sorrendjét (a műveletek prioritása)
    3. Térfogat/Űrtartalom (Volume) konvertáló
        * A számológép támogassa a következő mértékegységeket és az átváltást köztük:
            - A liter alapmértékegységet, ennek törtrészeit és többszöröseit
            - A köbméter alapmértékegységet, ennek törtrészeit és többszöröseit
            - Híres mértékegységek (cups, teaspoons, gallon ...)  *[elhanyagolható]*
        * Lehessen kiválasztani azt, hogy milyen mértékegységből szeretnénk átalakítani milyen mértékegységbe
    4. Hosszúség (Length) konvertáló    
        * A számológép támogassa a következő mértékegységeket és az átváltást köztük:
            - A méter alapmértékegységet, ennek törtrészeit és többszöröseit
            - A négyzetméter alapmértékegységet, ennek törtrészeit és többszöröseit
            - Híres mértékegységek (inch, feet ...)  *[elhanyagolható]*
        * Lehessen kiválasztani azt, hogy milyen mértékegységből szeretnénk átalakítani milyen mértékegységbe
    5. Tömeg (Weight) konvertáló
        * A számológép támogassa a következő mértékegységeket és az átváltást köztük:
            - A kilogramm alapmértékegységet, ennek törtrészeit és többszöröseit
            - Híres mértékegységek (pounds ...)  *[elhanyagolható]*
        * Lehessen kiválasztani azt, hogy milyen mértékegységből szeretnénk átalakítani milyen mértékegységbe
     6. Hőmérséklet (Temperature) konvertáló
        * A számológép támogassa a következő mértékegységeket és az átváltást köztük:
            - Celsius
            - Kelvin
            - Fahrenheit
        * Lehessen kiválasztani azt, hogy milyen mértékegységből szeretnénk átalakítani milyen mértékegységbe

2. Mindegyik számológép típushoz tartozzon egy saját oldal

3. Legyen valamilyen választási lehetőséget kínáló eszköz, mellyel választani lehet, hogy éppen melyik számológépet akarjuk használni

4. Támogasson History (Előzmény) módot
    - Az elvégzett számítások mentődjenek le
    - Az eddigi számításokat lehessen megnézni/kilistázni, a History gomb megnyomásával
    - Átlátható legyen, az egyes műveletek ne follyanak össze 


---


### A rendszerre vonatkozó szabályok (Ádám)


---


### Követelménylista (Dóra)

- K01. Könnyen üzemeltethetőség
- K02. Reszponzív GUI
- K03. Java
- K04. Cross-Platform
- K05. Előzmény mód
- K06. Matematikai alapműveletek
- K07. Matematikai haladó műveletek
- K08. Matematikai kifejezések kiértékelése
- K09. Térfogat/Űrtartalom konvertáló
- K10. Hosszúség (Length) konvertáló
- K11. Tömeg (Weight) konvertáló
- K12. Hőmérséklet (Temperature) konvertáló


---


### Fogalomszótár (Közös)

* **Előzmény (History) mód**: A korábban elvégzett műveletek listája/táblázata.
* **Cross-Platform**: Másnéven platformfüggetlenség, mely olyan operációs rendszerekre, programozási nyelvekre vagy számítógépes programokra, szoftverekre és implementációikra vonatkozik, amelyek több számítógépes platformon képesek mülködni. 
* **Platform**: Olyan hardver- és/vagy szoftverkörnyezet, mely meghatározza, hogy az adott számítógépen milyen más programok használhatók.

