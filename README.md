# Červené ryhy
Desktopová hra napísaná v Jave. Grafické prostredie je spravené cez JavaFX. Hráč bojuje proti rôznym zvieratám či mýtickým nepriateľom. 
Jeho cieľom je prebojovať sa cez úrovne s použitím správnych nástrojov a lektvarov. Nepriatelia majú silu a zdravie generované z určitého intervalu, čo dopomáha ku pestrosti hry.

## Použivateľský manuál
### Požiadavky

Použivateľ (hráč) potrebuje mať nainštalovaný a nastavený IntelliJ IDEA (prípadne obdobný program napr. VS Code, ale návod je písaný pre IntelliJ Idea).

Je potrebné si stiahnuť JavaFX SDK a rozbaliť si ho na miesto, ktoré si uživateľ ľahko
nezmaže (napr. C:\javafx-sdk-26).
### Pridanie JavaFX

Následne je potrebné, aby uživateľ prešiel v IntelliJ IDEA do nastavení štruktúry projektu
(File > Project Structure). Tu potrebuje vybrať v ľavom rohu knižnice (Libraries), kliknúť na
„+“ a vybrať „Java“. Je potrebné vybrať si priečinok v ktorom je rozbalená JavaFX a prejsť
do priečinku „lib“ (napr. C:\javafx-sdk-26\lib). Následne treba stlačiť „OK“ a potvrdiť aj
v hlavnom okne.

### Nastavenie konfigurácie spustenia

Teraz treba v hornom paneli pri zelenom trojuholníku vybrať „Edit Configurations...“, vybrať
si konfiguráciu pre „GUI_main“. Následne je potrebné kliknúť na „Modify options“
a zaškrtnúť „Add VM options“. Po tomto môžeme vložiť do políčka nasledujúci riadok (treba
si upraviť cestu ku lib priečinku):
„ --module-path "C:\javafx-sdk-26\lib" --add-modules javafx.controls,javafx.fxml --enable-
native-access=javafx.graphics “.

### Spustenie hry

Ak má použivateľ správne nastavené prostredie, môže stlačiť vpravo hore na zelený
trojuholník pri ktorom je nápis GUI_main.
