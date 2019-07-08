# ConsumesChangesAPI.md

Testerna använder en H2 databas. Som har  tabeller för lagring av skills-entiteter och occupation-name entiteter. Det behöver finnas model-klasser för de olika entiteterna.

Databasen fylls på med test-data i @Before steget, för att visa på ett befintlig tillstånd där den redan har sparat tex occupation-name entiteter.

Skapa tester och kod för att hantera changes-strömmen. Använd enbart mockad data så att den inte behöver gå till det riktiga API:et.

Skapa kod som hanterar ett CEATED event. Där den gör om data från ett changes-event till en "skills" entitet som den sparar ner i databasen.

Skapa kod som hanterar ett DEPRECATED event. Där den uppdaterar tex en "occupation-name" entitet som redan finns i databasen med en deprecated flagga.

Skapa kod som hanterar ett UPDATED event. Där den uppdaterar tex en "occupation-name" entitet som redan finns i databasen med en med en ny preferred-label.


När det finns kod i github som visar hur man uppdaterar en befintlig databas som redan har data i sig med hjälp changes-stömmen.

Koden använder sig enbart av mockad-data så den är inte beroende av att Taxonomy apiet är uppe.

Det finns exempel på hur man hanterar CREATED, DEPRECATED, UPDATED event.

Det finns kod som visar hur man hanterar två olika concept-typer, tex skills och occupation-name.

