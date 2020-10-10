# Követelmény specifikáció


### Jelenlegi helyzet leírása    
Cégünk kiállításszervezéssel foglalkozik nemzetközi szinten. Ügyfeleink összetétele nagyon diverzív, a legkülönbözőbb gazdasági szereplőkkel dolgozunk nap, mint nap.   
Jelenlegi ügyfeleink közül egy, amely a tudományok népszerűtésével kampányol, szeretne **a legújabb tudományos eredményekről kiállítás tartani**.    
A megrendelés végrehajtását már el is kezdtük, az igényelt szoftvereket már le is gyártattuk egy helyi céggel, viszont az ügyfelünkkel való legutóbbi konzultáció során mint az kiderült **az elkészült szoftverek egy része használhatatlanok vagy funkcionalitásban igen limitáltak**, így nem fogják őket használni.     
Ezekért a szoftverekért jelentős összeget adtunk ki, nem akarjuk elbukni a rájuk szánt támogatást, szeretnék ezeket a szoftvereket úgy átalakítani, hogy megfeleljen a megrendelőknek. Tisztában vagyunk azzal, hogy előfordulhat esetlegesen, hogy egy-egy szoftvert teljesen újra kell írni.     
Az érintett szoftverek matematikai programok amiket különböző új, innovatív eszközökre szántak.      

Az egyik érintett szoftver egy __*számológép program amit egy könnyen hordozható, handheld scanner eszközre*__ írtak. Az eszköz használatával tetszőleges matematikai kifejezés értékelhető ki scannelés után, természetesen nem fedi le a matematika teljes területét a funkcionalitás a képességei dokumentálva vannak. Az eszközt oktatók számára tervezték, hogy időt spórolva, gyorsan tudjanak dolgozatokat javítani.
A gond vele az, a _megrendelő_ szerint, hogy hibásan implementálták a _tokenizer_ és _parser_ részeit, illetve a nyelvtani szabályokat is szintén. Helytelen eredménnyel szolgáltat, ami nem tudható be a hardver hibájába.     

A másik egy __*nanogépekkel működő univerzális mérlegre*__ írt konverziós program. A mérleget több település piaca rendelte már meg, viszont a programja nagymértékben korlátolt, ugyanis limitált a lebegőpontos aritmetikája. Hosszú távon ez bevételkiesést jelent a kereskedők számára.    

Az utolsó __*egy valódi randomszámgenerátor részmodulja*__. Különböző PI-t megközelítő algoritmusokat implementáltak, hogy előállítsák annak számjegyeit decimális, illetve hexadecimális formátumba. A limitált lebegőpontos aritmetikája, és a párhuzamosítása miatt elfogadhatatlan állapotban van a program. A számítások beállíthatóak, például iterációshatár adható meg, vagy ha például a BPP algoritmus használjuk akkor indexhatárok is.

Egységesen a futási,s zámítási és egyéb adatokat egyszerűen egy szimpla fájlba mentik.

---


### Vágyálomrendszer leírása     

Ügyfelünk a javítások mellett igényel egyfajta **PoC** programot amivel egyszerűen tesztelni tudják a kért funkcionalitásokat.    
Ez a program, mivel ők rengeteg architektúrával dolgoznak, cross-platform kell, hogy legyen, a Java platformot preferálják.  
Szeretnék, ha megkapnánk magát a forráskódot is, hogy ők helyileg letudják fordítani a különböző eszközeikre a programot. Build rendszernek a Maven projektet használják.    
**A kód minősége is szempont** számukra, tesztelhető kódot várnak és preferálnánk az olyan könyvtárak használatát, mint a Lombok, de ez a programozókra van bízva.
Az ügyfél adatbázist üzemeltet és szeretné, ha a következő műveletek eredménye rögzítésre kerülne egy-egy megfelelő táblában:
1. Kifejezés OCR olvasó esetében:
    * Kifejezés kiértékelése
2. Konverziós program esetében:
    * Az egyes átváltások
3. PI-t megközelítő modul esetében:
    * A megközelítés

**Az adatbázist ők maguk fogják rákötni a programra**, a fejlesztők tetszőleges adatbázist használhatnak a szoftverfejlesztés ideje alatt.   
Kérik viszont, a táblákat legeneráló SQL szkripteket, illetve az egyes relációkat reprezentáló osztálystuktúrát.


Maga a PoC program legyen reszponzív, licence kérdések miatt a JavaFX könyvtárat kell használniuk a programozóknak.   

---


### Jelenlegi üzleti folyamatok (Ádám)


---


### Igényelt üzleti folyamatok (Dóra)


---


### A rendszerre vonatkozó szabályok (Ádám)


---


### Követelménylista (Dóra)


---


### Fogalomszótár (Közös)
Fogalmak:
* **Linux**: Avagy Linux-rendszermag, rendszermag.  
* **Rendszermag**: Az operációs rendszer erőforrásait kezelő program.
* **Linux disztribúció**: A Linux-disztribúciók a Linux-kernelre épülő terjesztések. Linux kernel mellett több-kevesebb szabad szoftvert és kereskedelmi szoftvert tartalmazhatnak.  
* **GNU/Linux, GNU+Linux, ...**: Linux nem egy operációs rendszer magában, inkább egy újabb szabad komponense a teljesen fukcionáló GNU rendszernek, amelyeket a GNU corelibs, shell eszközök és létfontosságú rendszerkomponensek műküödtetnek egy teljes OS-ként, POSIX-meghatározás szerint.
* **GUI (Graphic User Interface)**: A felület amit a felhasználó lát és ahol a program funkcióit használja
* **Cross-Platform**: Másnéven platformfüggetlenség, mely olyan operációs rendszerekre, programozási nyelvekre vagy számítógépes programokra, szoftverekre és implementációikra vonatkozik, amelyek több számítógépes platformon képesek mülködni. 
* **Platform**: Olyan hardver- és/vagy szoftverkörnyezet, mely meghatározza, hogy az adott számítógépen milyen más programok használhatók.
* **OCR**: Avagy optikai karakterfelismerés vagy az optikai karakterolvasó, amelyet gyakran rövidítettek OCR-ként, a gépelt, kézzel írt vagy nyomtatott szövegek gépi kódolású, mechanikus vagy elektronikus átalakítása, akár beolvasott dokumentumból, akár egy dokumentum fotójából, egy jelenetfotóból (például a tájképen lévő jelzéseken és hirdetőtáblákon található szöveg), vagy a feliratú szöveg egy képben (például egy televíziós műsorból) .
* **SQL**: Az SQL, azaz Structured Query Language (strukturált lekérdezőnyelv) relációsadatbázis-kezelők lekérdezési nyelve.
Angol nyelvterületen 'eszkjuel' a kiejtése. A hagyományokhoz való hűség jegyében sokan 'szíkvel'-nek ejtik, ugyanis korábban Structured English Query Language (SEQUEL) volt az elnevezés, és ezt rövidítették le.
A relációsadatbázis-kezelők általában az SQL nyelven programozhatók. Az SQL alapvető utasításait közel egyformán valósítják meg, de a később beépült nyelvi elemek körében nagyon nagy az eltérés, az inkompatibilitás, emiatt számos SQL nyelvjárásról beszélhetünk.
Jellegét tekintve ez a szakterület-specifikus nyelv részben procedurális, részben deklaratív. 
* **Java**: A Java általános célú, objektumorientált programozási nyelv, amelyet a Sun Microsystems fejlesztett a ’90-es évek elejétől kezdve egészen 2009-ig, amikor a céget felvásárolta az Oracle.
A Java alkalmazásokat jellemzően bájtkód formátumra alakítják, de közvetlenül natív (gépi) kód is készíthető Java forráskódból. A bájtkód futtatása a Java virtuális géppel történik, ami vagy interpretálja a bájtkódot, vagy natív gépi kódot készít belőle, és azt futtatja az adott operációs rendszeren.
A Java nyelv a szintaxisát főleg a C és a C++ nyelvektől örökölte, viszont sokkal egyszerűbb objektummodellel rendelkezik, mint a C++
* **JavaFX**: Egy grafikai keretrendszer a Java platform számára.
* **Maven**: Egy build system a Java platform számára.