# Rendszerterv


### A rendszer célja (Ádám)


---


### Projekt terv (Ádám)
	

---


### Üzleti folyamatok modellje
1. Üzleti szereplők
   * Ügyfél ügyfelének munkatársai
   * Kiállítás résztvevői
   * Kiállítás szervezői
   * A rendezvényben érdekelt illetékes hatóságok
   * Üzleti munkatársak:
        * Rendszergazdák
        * IT osztály tagjai
        * Fejlesztők
        * Adatbázis adminisztrátorok

2. Üzleti folyamatok
    * Tanítás, oktatás
    * Számítások elvégzése
    * Könyvelés
    * Naplózás
    * Optikai karakterfeldolgozás
    * Adatbázis elérés
    * PI megközelítése
    * Mérések különböző szenzorok segítségével
    * Karbantartás
    * Üzemeltetés    
    * Szoftverek elérhetőségének biztosítása

3. Üzleti entitások
    * Operációs rendszerek
    * Internet
    * Intézmény
    * Kiálltásszervezők
    * Kiállítás
    * Adatbázis
    * Tárhely
    * Rendszergazdai csoport
    * Fejlesztői csapat(ok)
---


### Követelmények (Dóra)


--- 


### Funkcionális terv
A funkcionális specifikációban leírt használati esetek alapján kell ejárnunk.   
Implementációs segítségét a Class Diagram és a Database Scheme fog nyújtani.    

## **BasicCalculator esetén a következőket mondhatjuk el:**

A matematikai függvényeket, beleértve az alapműveleteket, saját osztályaink alapján fogjuk szolgáltatni.   
A rendszer főbb osztályai:   
* _BasicCalculator_ osztály:
    * Nyomonköveti egy tagváltozóban az aktuális részeredményt
    * A "Controller" osztályban példányosodik
    * Nyomonköveti az aktuálisan alkalmazandó operátort is  
        * Ha nincs mentve jelenleg, akkor mentés kijelzőről + operátor maga
        * Ha van mentve, akkor részkiértékelés
* _BasicMath_ osztály:
    * Implementálja az _IBasicMathFunctionality_ interfészt
    * Wrapper a StrictMath-ra nézve
* _Calculation_ osztály:
    * Data class
    * Hordozza az operátort és (egyik) operanduszát            
* _ConstantProvider_ osztály:
    * Statikus osztály, nem példányosítható
    * Statikus függvények révén ad vissza definiált konstans értékeket    
* _HistoryModule_ osztály:
    * Singleton osztály
    * Minden részkiértékelés eredménye rögzítésre kerül ```logCalculation(Calculation c)``` metódusa révén
    * Biztosítja a Történelem funkciót
    * Module Interfészből ered
* _BasiCalculatorApplication_ osztály:
    * Lényegében a Main()-t definiáló osztály, _Controller_
    * Itt történik az FXML betöltése     
    * FXML Contoljainak bekötése..   
* _BasicCalculatorController_ osztály:
    * Az MVC modelben ő valósítja meg a Controllert
    * Összeköti a View és Modellt

![classdiagram](diagrams/class_diagram_bc.png)

## **AdvancedCalculator esetén a következőket mondhatjuk el:**  
Azonos az architekturális a **BasicCalculator** programmal, viszont bővel egy _Tokenizer_ és _Parser_ osztállyal egy új csomagban.   

A _Tokenizer_ osztály:
* A bemenetet karakterenként olvassa _Token_-eket állít elő
* Az előállított _Token_-eket olvasási sorrendet megtartva kerül átadásra a _Parser_ példánynak
* Hibát dob ismeretlen bemenet esetén
_Token_ osztály:     
* Érvényes matematikai kifejezést/utasítást reprezentáló osztály

_Parser_ osztály:
* Kapott tokensorozatot értékel ki a beprogramozott nyelvtani szabályok alapján
* Hibát dob szintaktikai hiba esetén

![classdiagram](diagrams/ac_class_diagram.png)

## **PICalculator esetén a következőket mondhatjuk el:**  
_IApproximator_ osztály:
* Interfész amit a PI-t közelítő osztályok implementálnak
(Chudnovsky, Zeta, BBP, Leibniz, ...)
* Mivel Javaban nem értelmezett az alapértelmezett paraméter megadása, overloadoljuk az `approximatePI` metódust    

_&lt;Approximator&gt;_ alosztályok:
* Implementálják az _IApproximator_ interfészt
* Az adott metódus alapján közelítik PI értékét decimális formában

_BBPApproximator_ osztály:
* Speciális közelítő
* A PI-nek hexadecimális számjegyeit határozza meg

![classdiagram](diagrams/pi_class_diagram.png)

## **Converter esetén a következőket mondhatjuk el:**      
_Converter_ absztrakt osztály:
* Absztrakt osztály amelyet az egyes _Converter_ alosztályok bővítenek
* Az átváltások egy _conversionTable_ nevű kulcstranszformációs táblázat alapján történik     
    * Ezek tartalma konstans, soha nem változhat
* _&lt;*Converter&gt;_  osztályok     
    * Az átváltásokat valósítják meg      
    
![classdiagram](diagrams/cv_class_diagram.png)



## **Adatbázis séma**      
Mivel az ügyfél saját adatbázist üzemeltet nem volt szükség túltervezni az általunk majd a fejlesztés és tesztelés folyamatok alatt használt adatbázissémát.   
A `tinylog` naplózó könyvtár konfigurációs állományra építve a következő szimpla, naplóbejegyzéseket tartalmazó adatbázist fogjuk létre hozni `h2` relációs adatbázisrendszerben:   
![classdiagram](diagrams/database_schema.png)


...
---


### Fizikai környezet (Dóra)


---


### Architekturális terv (Ádám)


---

### Tesztterv
Alapvetően a cél a kért forráskódok letesztelése a cél, nem konkrét célunk a hozzá készült PoC program alapos tesztelése, viszont mivel demonstrálásra szeretnék felhasználni muszáj tesztelnünk annak működését:
1. Vannak-e eseménykezelő metódusok rendelve az egyes Controllokhoz?
2. Helyes eseménykezelő hívódik-e meg adott Control esetében?
3. Ha egy Control több eseményét is kezeljük akkor a helyes eseménykezelő hívódik-e meg?
4. Átméretezhető az ablak?
5. Átméretezéskor követik a Control-ok a befoglaló Container arányait?
6. Az főablak bezárásakor ténylegesen megszakítódik a program?

A forráskódokat a megadott igények mentén kell tesztelnünk, ha ezek a tesztek sikeresen lefutnak akkor átadható az ügyfélnek az elkészült, javított forráskód.  

## **OCR hardver számológép esetében:**
1. A beírt, szintaktikailag helyes matematikai kfiejezést helyesen értékeli-e ki a kapcsolódó metódus?
2. Ha beírt, szintaktikailag helytelen kifejezést értékelünk ki akkor hibával tér-e vissza a metódus?
3. Ha beírt, szintaktikailag helyes de nem támogatott matematikai kfiejezést értékelünk ki akkor hibával tér-e vissza a kiértékelő metódus?
4. Használató-e más IAdvancedMath interfészt implementáló osztály-e?
5. A program helyes naplózza az elvégzett műveleteket az adatbázisba?
6. A program megfelelő lebegőpontos aritmetikai pontosság mellett dolgozik?
7. A tokenizer dob-e hibát érvénytelen karakter feldolgozásakor?
8. A parser helyesen alkalmazza a nyelvtani szabályokat?
---


### Telepítési terv (Dóra)


---


### Karbantartási terv (Dóra)

