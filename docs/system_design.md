# Rendszerterv


### A rendszer célja (Ádám)


---


### Projekt terv (Ádám)
	

---


### Üzleti folyamatok modellje (Tamás)


---


### Követelmények (Dóra)


--- 


### Funkcionális terv (Tamás)


---


### Fizikai környezet (Dóra)


---


### Architekturális terv (Ádám)


---

### Tesztterv (Tamás)
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

