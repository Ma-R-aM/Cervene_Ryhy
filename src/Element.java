/**
 * Reprezentuje elementy nepriatelov v hre.
 * Kazdy element ma specificke vlastnosti a ucinky v boji:<br>
 * - Normalny: Jedna sa o klasickeho nepriatela<br>
 * - Ohnivy: Pripravuje zapasnika o zdravie<br>
 * - Elektricky: Moze zelelektrizovat hraca s kovovou zbranou<br>
 * - Jedovaty: Pripravuje zapasnika o zdravie po urcity pocet kol<br>
 * - Vodny: Nema specialne ucinky na hraca, ale sluzi na odlisenie typu nepriatela<br>
 * 
 * @see EntityPrisera
 */
public enum Element
{
    Normalny, Elektricky, Ohnivy, Vodny, Jedovaty
}
