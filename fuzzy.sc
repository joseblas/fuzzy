import java.util.Locale

import fuzzy.CompanyData._

distance("Goyal and Sons", "Goyal")

distance("Glaxo-Smith Kline", "GSK")
distance("GlaxoSmithKline", "GSK")
distance("Glaxo", "GSK")

distance("GSK", "Glaxo-Smith Kline" )
distance("GSK", "GlaxoSmithKline" )
distance("GSK", "Glaxo" )


distance("JT Coder Limited", "JT Coder Ltd")