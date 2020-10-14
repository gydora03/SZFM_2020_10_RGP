# Rendszerterv


### A rendszer célja (Ádám)


---


### Projekt terv (Ádám)
	

---


### Üzleti folyamatok modellje (Tamás)


---


### Követelmények (Dóra)

1. Alap (Basic) számológép
    - Alap műveletek végrehajtása
        * művelet végrehajtásának a menete: operandus megadása -> művelethez szükséges operátor -> újabb operandus -> egyenlő operátor -> az eredmény megjelenik a kijelzőn
        * összetettebb műveletsorok elvégzése is lehetséges, ekkor az egyenlő operátor helyett újabb alap műveletet jelölő operátor jön, majd újabb operandus. A műveletsor végén, ha már nem akarunk újabb műveleteket elvégezni, akkor az egyenlő operátor megnyomásával lezárjuk a műveletsort és megjelenítjük az eredmény.
    - Haladó matekatikai koncepciók végrehajtása
        * művelet végrehajtásának a menete: operandus megadása -> a művelethez szükséges operátor -> az eredmény autómatikusan megjelenik a kijelzőn, anélkül, hogy megnyomnánk az egyenlő operátort.
        * műveletsorok elvégzése közben is használhóak ezek a funkciók.
2. Haladó (Advanced) számológép
    - Alap műveletek végrehajtása
        * művelet végrehajtásának a menete: operandus megadása -> művelethez szükséges operátor -> újabb operandus -> egyenlő operátor -> az eredmény megjelenik a kijelzőn
        * összetettebb műveletsorok elvégzése is lehetséges, ekkor az egyenlő operátor helyett újabb alap műveletet jelölő operátor jön, majd újabb operandus. A műveletsor végén, ha már nem akarunk újabb műveleteket elvégezni, akkor az egyenlő operátor megnyomásával lezárjuk a műveletsort és megjelenítjük az eredmény.
    - Haladó matekatikai koncepciók végrehajtása
        * művelet végrehajtásának a menete: operandus megadása -> a művelethez szükséges operátor -> az eredmény autómatikusan megjelenik a kijelzőn, anélkül, hogy megnyomnánk az egyenlő operátort.
        * műveletsorok elvégzése közben is használhóak ezek a funkciók.
    - Öszetett matematikai kifejezések végrehajtása:
        * művelet végrehajtásának a menete: zárójelek, operandusok és operátorok segítéségével megadni a matematikai kifejezést -> egyenló operátor -> az ifejezés eredménye megjelenik a kijelzőn.
3. PI számológép
    - művelet végrehajtásának a menete: ki kell választani hogy melyik módszert szeretnénk használni -> megadni a számításhoz szükséges paramétereket -> Calculate gomb megnyomása -> az eredmény megjelenik a képernyőn
4. Térfogat/Űrtartalom (Volume) konvertáló
    - művelet végrehajtásának a menete: kiválasztani hogy melyik mértékegységből szeretnénk konvertálni -> kiválasztani hogy melyik mértékegységbe szeretnénk konvertálni -> megadni a mennyiséget amit konvertálni szeretnénk -> Convert gomb megnyomása -> a konvertálás eredménye megjelenik a megfelelő cellában
    - a Convert gomb megnyomása előtti műveletek sorrendje felcserélhető
 5. Hosszúség (Length) konvertáló
    - művelet végrehajtásának a menete: kiválasztani hogy melyik mértékegységből szeretnénk konvertálni -> kiválasztani hogy melyik mértékegységbe szeretnénk konvertálni -> megadni a mennyiséget amit konvertálni szeretnénk -> Convert gomb megnyomása -> a konvertálás eredménye megjelenik a megfelelő cellában
    - a Convert gomb megnyomása előtti műveletek sorrendje felcserélhető
6. Tömeg (Weight) konvertáló
    - művelet végrehajtásának a menete: kiválasztani hogy melyik mértékegységből szeretnénk konvertálni -> kiválasztani hogy melyik mértékegységbe szeretnénk konvertálni -> megadni a mennyiséget amit konvertálni szeretnénk -> Convert gomb megnyomása -> a konvertálás eredménye megjelenik a megfelelő cellában
    - a Convert gomb megnyomása előtti műveletek sorrendje felcserélhető
7. Hőmérséklet (Temperature) konvertáló
    - művelet végrehajtásának a menete: kiválasztani hogy melyik mértékegységből szeretnénk konvertálni -> kiválasztani hogy melyik mértékegységbe szeretnénk konvertálni -> megadni a mennyiséget amit konvertálni szeretnénk -> Convert gomb megnyomása -> a konvertálás eredménye megjelenik a megfelelő cellában
    - a Convert gomb megnyomása előtti műveletek sorrendje felcserélhető
8. ELőzmény (History) mód használata
    - az elózmények előhívása nagyon egyszerű, a "Hist" gomb megnyomásával egy ablakban láthatóvá válnak az eddigi műveletek és eredményeik
    - az egyes műveletek egymástól jól elkülönítve láthatóak
    - az előzmények között csak azok a műveletek láthatóak, amelyek a program elindítása óta lettek elvégezve, a program bezárásával az előzmények is eltünnek.
    - csak az alap és a haladó számológép esetén hívható elő


--- 


### Funkcionális terv (Tamás)


---


### Fizikai környezet (Dóra)

- Reszponzív megjelenés
- A program Java nyelven legyen írva, a fejlesztéshez és teszteléshez használt felületek, eszközök szabadon választhatóak
- A GUI JavaFX alapokon legyen, a számológép és a konverterek kinézete SceneBuilder használatával legyen összeállítva
- Az Előzmény mód nem igényel adatbázist, ezért nem szükséges annak üzemeltetése sem, az előzmények egy ablakban lesznek megjelenítve
- A program Windows, Mac OS illetve Linux operációs rendszereken egyaránt futtatható és használható

---


### Architekturális terv (Ádám)


---

### Tesztterv (Tamás)


---


### Telepítési terv (Dóra)


---


### Karbantartási terv (Dóra)

