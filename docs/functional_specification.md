# Funkcionális specifikáció  


### A rendszer céljai és nem céljai (Ádám)


---


### Jelenlegi helyzet leírása (Tamás)
Egy kiállításszervező cég ügyfele tudományos kiállítás szeretne rendezni, az igényelt szoftvereiket már megírta egy cég, viszont a kommunikáció teljes hiánya miatt az elkészült termékek nagyrésze használhatatlan vagy korlátolt működésben.  
Felkértek minket ezen szoftverek javítására, illetve új programok megírására amennyiben a javítás adott szoftver esetén nem lehetséges.    
A szoftvereket speciális hardverekre szánják, például egy __*nanogépekkel működő univerzális mérlegre*__, nekünk ezt nem kell figyelembe venni, mert ezekre az architektúrákra implementálva van a Java Virtuális Gép.     
A szoftverek jelenleg adatokat mentenek a lemezre.    
A korlátolt működés legfőbbképpen a lebegőpontos aritmetika pontatlanságában mutatkozik meg, de panaszkodnak a kapott forráskódok tesztelhetőségére is.   
A megrendelés 3 szoftverre szól, ezeknek speciális hibáik a következőek:
1. **OCR számológép**:
    * Hibás tokenizer és parser
    * Hibás kifejezéskiértékelés
    * Aritmetikai pontatlanság
2. **Nanogépekkel működő univerzális mérleg**:
    * Aritmetikai pontatlanság ami bevételkiesést jelent hosszútávon a termék felhasználóinak(gazdasági szereplők)
3. **Valódi randomszámegenerátor részmodulja**:
    * Aritmetikai pontatlanság
    * Párhuzamosítás teljes hiánya

---


### Vágyálom rendszer leírása (Tamás)

Legfőbb elvárásuk, hogy helyes működsére bírjuk a hibás szoftvertermékeket.      
Kérnek egy **PoC** programot is amivel egyszerűen tesztelhetik kézileg és __programmatically__ a funkcionalitásokat.      

A kód minősége __*nagyon*__ fontos számukra, elvárják olyan modern szoftverfejlesztést könnyítő könyvtárak használatát, mint például a boiler kódokat automatikus megíró **Lombok** könyvtárét.        
Szeretnék, hogy a programok ne egyszerűen egy szimpla fájlba rögzítsét a számítások eredményeit hanem egy adatbázisba.    

* Az adatbázist ők üzemeltetik, de szükségük van a relációkat elkészítő SQL szkriptekre     

* A fejlesztés alatt tetszőleges adatbázist használhatunk, ez mi esetünkben most a **h2** adatbázis lesz egyszerűsége miatt.    

Cross-platform elvárás miatt a Java platformra kell megírnunk a forráskódot, illetve a Maven build rendszert kell használnunk a projekthez, mivel ők is ezt használják cégen belül.    

Kimondott fejlesztések:
1. **OCR számológép**:
    * Tokenizer
    * Parser
    * Kifejezéskiértékelés környezetfüggetlen grammatikával
        * Double típus pontásságával dolgozhatunk
    * Adatbázisba való mentés
    
2. **Nanogépekkel működő univerzális mérleg**:
    * Függetlenség az aritmetikai pontosságra nézve az __*Apfloat*__ könyvtár használatával
    * Átváltás különböző mértékek között
    * Adatbázisba való mentés
3. **Valódi randomszámegenerátor részmodulja**:
     * Függetlenség az aritmetikai pontosságra nézve az __*Apfloat*__ könyvtár használatával
    * Algoritmusok párhuzamosítása
    * Adatbázisba való mentés

Kérnek ezenkívül **Markdown** formátumban dokumentált, **JUnit** keretrendszerrel történő egység tesztelést is a projekre.

---


### Jelenlegi üzleti folyamatok modellje (Ádám)


---


### Igényelt üzleti folyamatok modellje (Dóra)


---


### Követelménylista (Dóra)


---


### Használati esetek [Use cases] (Tamás)


---


### Képernyő tervek (Dóra)


---


### Fogalomszótár (Közös)

