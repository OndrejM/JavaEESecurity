# JavaEESecurity

Ukážkový projekt, ako je možné implementovať prihlásenie a kontrolu oprávnení v Java EE aplikácii.

 - git branch **master** obsahuje počiatočný stav - môžete si na ňom riešenie vykúšať
   - kroky, ktoré sme implementovali
     1. autentifikácia pomocou formulára (namiesto BASIC) - treba dať pozor na faces redirect
     2. kontrola oprvánení najprv pomocou Java EE anotácií na EJB (@RolesAllowed, @PermitAll, @Resource EjbContext)
     3. kontrola oprvánení vlastným spôsobom pomocou autorizačného EJB
     4. kontrola oprávnení pomocou vlastných anotácií a CDI interceptora
 - git branch **hotove** obsahuje hotový stav riešenia prihlásenia cez formulár a kontroly oprávnení cez Java EE anotácie na EJB
 - git branch **hotove-roles-rights** obsahuje hotové riešenie pre kontrolu oprávnení cez vlastné role a oprávnenia, a CDI interceptory
