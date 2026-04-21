# 🗺️ Textová RPG Adventura

Vítejte v repozitáři pro textovou RPG adventuru. Tento projekt představuje klasickou konzolovou hru, která se zaměřuje na průzkum lokací, správu inventáře a souboje s nepřáteli.

Hlavním architektonickým prvkem tohoto herního enginu je jeho **daty řízený design (data-driven design)**. Celý herní svět, včetně rozložení místností, předmětů a vlastností nepřátel, je dynamicky načítán z externího textového souboru. To umožňuje snadnou tvorbu nových úrovní a modifikaci hry bez nutnosti zásahu do samotného zdrojového kódu.

## 🛑 Status vývoje (Archivováno)

**Tento projekt je považován za kompletní a finální.** Neplánuje se jeho další vývoj, úpravy kódu, opravy ani přidávání nových funkcí. Repozitář je ponechán v tomto stavu jako hotové řešení a ukázka funkčního enginu dle původního zadání.

## ✨ Klíčové vlastnosti

- **Navigace ve světě:** Systém pohybu založený na čtyřech světových stranách (Sever, Jih, Východ, Západ).
- **Rozsáhlé mapy:** Plná podpora pro komplexní sítě místností (aktuální datová sada obsahuje 11 propojených lokalit).
- **Správa inventáře:** Hráč disponuje batohem pro sběr a využívání předmětů. Systém rozlišuje mezi předměty, které lze přenášet, a těmi, které jsou fixně vázány na lokaci.
- **Dynamické souboje:** Interakce s nepřátelskými entitami, podpora pro agresivní i pasivní chování.
- **Stav výhry:** Hra obsahuje definované podmínky pro úspěšné dokončení příběhu.
- **Vysoká modularita:** Snadná úprava světa pomocí formátovaného textového souboru.

## 📖 Příběhové pozadí

Probouzíte se dezorientovaní na neznámém místě s prázdnýma rukama. Vaše cesta začíná na pomezí jezera a hlubokého lesa. Vaším úkolem je projít nebezpečnou divočinou, překonat zrádné řeky a rozlehlé pláně, abyste dosáhli finální lokace a odhalili smysl své cesty. Během putování budete muset shromažďovat vybavení a čelit hrozbám, které se v tomto světě skrývají.

## 🛠️ Stav projektu & Poslední změny

**Aktuální verze (Final Commit):** Hra je plně hratelná a funkční.
- Opravena logika soubojového systému (enemies fix).
- Vylepšena správa stavu předmětů (použité předměty nejsou chybně vraceny).
- Aktualizována a sjednocena specifikace datového formátu uvnitř `data.txt`.

## 📊 Výchozí hodnoty hráče

Pokud herní předměty neurčí jinak, základní statistiky hráče jsou nastaveny následovně:
- **Zdraví (HP):** 100
- **Poškození (Damage):** 10
- **Obrana (Defense):** 0

---

## ⚙️ Průvodce formátováním dat (`data.txt`)

Herní svět je definován v souboru `data.txt`. Záznamy jsou rozděleny do logických bloků pomocí klíčových slov začínajících znakem `#`.

### 1. Místnosti (`#ROOMS`)
Definuje uzly mapy a jejich propojení.
* **Architektonické pravidlo:** Startovní místnost musí mít vždy `ID 0`. Identifikátory místností musí být definovány ve vzestupném pořadí tak, jak byly vytvořeny. Pokud určitým směrem nevede žádná cesta, používá se hodnota `NULL`.
* **Formát:** `ID, NÁZEV, POPIS, SEVER, JIH, VÝCHOD, ZÁPAD`

**Příklad:**
```csv
#ROOMS
0,STARTING ROOM,THIS IS THE START,LAKE,FOREST,FLOWER FIELD,NULL
1,FOREST,NONE,STARTING ROOM,NULL,NULL,NULL
2,FLOWER FIELD,NONE,FIELD,NULL,RIVER,NULL