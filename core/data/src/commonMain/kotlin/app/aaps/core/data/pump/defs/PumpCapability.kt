package app.aaps.core.data.pump.defs

import app.aaps.core.data.pump.defs.Capability.*

enum class PumpCapability {

    // grouped by pump
    MDI(arrayOf(Capability.Bolus)),
    VirtualPumpCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery)),
    ComboCapabilities(arrayOf(Capability.Bolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.TDD, Capability.ManualTDDLoad)),
    DanaCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.TDD, Capability.ManualTDDLoad)),

    DanaWithHistoryCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.TDD, Capability.ManualTDDLoad)),
    InsightCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.BasalRate30min)),
    MedtronicCapabilities(arrayOf(Capability.Bolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.TDD)),
    OmnipodCapabilities(arrayOf(Capability.Bolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.BasalRate30min)),
    YpsomedCapabilities(
        arrayOf(
            Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.TDD, Capability.ManualTDDLoad
        )
    ),  // BasalRates (separately grouped)
    DiaconnCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.Refill, Capability.ReplaceBattery, Capability.TDD, Capability.ManualTDDLoad)), //
    EopatchCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.BasalRate30min)),
    MedtrumCapabilities(arrayOf(Capability.Bolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.BasalRate30min, Capability.TDD)), // Technically the pump supports ExtendedBolus, but not implemented (yet)
    CarelevoCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.BasalRate30min)),

    // Diaconn set without Refill and ReplaceBattery: the Equil wizard fills the reservoir and fits the charged battery
    EquilCapabilities(arrayOf(Capability.Bolus, Capability.ExtendedBolus, Capability.TempBasal, Capability.BasalProfileSet, Capability.TDD, Capability.ManualTDDLoad));
    MDI(Bolus),
    VirtualPumpCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery),
    ComboCapabilities(Bolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, TDD, ManualTDDLoad),
    DanaCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, TDD, ManualTDDLoad),
    DanaWithHistoryCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, TDD, ManualTDDLoad),
    InsightCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, BasalRate30min),
    MedtronicCapabilities(Bolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, TDD),
    OmnipodCapabilities(Bolus, TempBasal, BasalProfileSet, BasalRate30min),
    YpsomedCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, TDD, ManualTDDLoad),  // BasalRates (separately grouped)
    DiaconnCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, Refill, ReplaceBattery, TDD, ManualTDDLoad), //
    EopatchCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, BasalRate30min),
    MedtrumCapabilities(Bolus, TempBasal, BasalProfileSet, BasalRate30min, TDD), // Technically the pump supports ExtendedBolus, but not implemented (yet)
    CarelevoCapabilities(Bolus, ExtendedBolus, TempBasal, BasalProfileSet, BasalRate30min),
    TandemSlimCapabilities(Refill, ReplaceBattery),
    TandemMobiCapabilities(Bolus, TempBasal, BasalProfileSet, Refill, BasalRate30min);

    var children: ArrayList<Capability> = ArrayList()

    constructor(vararg capabilities: Capability) {
        for (capability in capabilities) {
            children.add(capability)
        }
    }

    fun hasCapability(capability: Capability): Boolean = children.contains(capability)
}
