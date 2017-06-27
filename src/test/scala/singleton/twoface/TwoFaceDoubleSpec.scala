package singleton.twoface

import singleton.twoface.math._
import org.scalacheck.Properties
import shapeless.test.illTyped
import singleton.TestUtils._

class TwoFaceDoubleSpec extends Properties("TwoFace.Double") {
  property("Implicit Creation[]") = {
    val a = implicitly[TwoFace.Double[2.0]]
    a.getValue == 2.0 && a.isLiteral
  }
  property("Safe Creation[]") = {
    val a = TwoFace.Double[2.0]
    a.getValue == 2.0 && a.isLiteral
  }
  property("Safe Creation()") = {
    val a = TwoFace.Double(2.0)
    a.getValue == 2.0 && a.isLiteral
  }
  property("Unsafe Creation()") = {
    val a = TwoFace.Double(us(2.0))
    a.getValue == 2.0 && !a.isLiteral
  }

  property("Safe ifThenElse") = verifyTF(ifThenElse(true, 1.0, 2.0), 1.0)
  property("Unsafe ifThenElse") = verifyTF(ifThenElse(us(false), 1.0, 2.0), us(2.0))

  property("Pi") = verifyTF(Pi, 3.141592653589793)
  property("E") = verifyTF(E, 2.718281828459045)

  property("Safe Double + Safe Char") = verifyTF(TwoFace.Double(2.0) + TwoFace.Char('\u0001'), 3.0)
  property("Safe Double + Unsafe Char") = verifyTF(TwoFace.Double(2.0) + TwoFace.Char(us('\u0001')), us(3.0))
  property("Unsafe Double + Safe Char") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Char('\u0001'), us(3.0))
  property("Unsafe Double + Unsafe Char") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Char(us('\u0001')), us(3.0))
  property("Safe Double + Safe Int") = verifyTF(TwoFace.Double(2.0) + TwoFace.Int(1), 3.0)
  property("Safe Double + Unsafe Int") = verifyTF(TwoFace.Double(2.0) + TwoFace.Int(us(1)), us(3.0))
  property("Unsafe Double + Safe Int") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Int(1), us(3.0))
  property("Unsafe Double + Unsafe Int") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Int(us(1)), us(3.0))
  property("Safe Double + Safe Long") = verifyTF(TwoFace.Double(2.0) + TwoFace.Long(1L), 3.0)
  property("Safe Double + Unsafe Long") = verifyTF(TwoFace.Double(2.0) + TwoFace.Long(us(1L)), us(3.0))
  property("Unsafe Double + Safe Long") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Long(1L), us(3.0))
  property("Unsafe Double + Unsafe Long") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Long(us(1L)), us(3.0))
  property("Safe Double + Safe Float") = verifyTF(TwoFace.Double(2.0) + TwoFace.Float(1.0f), 3.0)
  property("Safe Double + Unsafe Float") = verifyTF(TwoFace.Double(2.0) + TwoFace.Float(us(1.0f)), us(3.0))
  property("Unsafe Double + Safe Float") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Float(1.0f), us(3.0))
  property("Unsafe Double + Unsafe Float") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Float(us(1.0f)), us(3.0))
  property("Safe Double + Safe Double") = verifyTF(TwoFace.Double(2.0) + TwoFace.Double(1.0), 3.0)
  property("Safe Double + Unsafe Double") = verifyTF(TwoFace.Double(2.0) + TwoFace.Double(us(1.0)), us(3.0))
  property("Unsafe Double + Safe Double") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Double(1.0), us(3.0))
  property("Unsafe Double + Unsafe Double") = verifyTF(TwoFace.Double(us(2.0)) + TwoFace.Double(us(1.0)), us(3.0))

  property("Safe Double - Safe Char") = verifyTF(TwoFace.Double(2.0) - TwoFace.Char('\u0001'), 1.0)
  property("Safe Double - Unsafe Char") = verifyTF(TwoFace.Double(2.0) - TwoFace.Char(us('\u0001')), us(1.0))
  property("Unsafe Double - Safe Char") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Char('\u0001'), us(1.0))
  property("Unsafe Double - Unsafe Char") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Char(us('\u0001')), us(1.0))
  property("Safe Double - Safe Int") = verifyTF(TwoFace.Double(2.0) - TwoFace.Int(1), 1.0)
  property("Safe Double - Unsafe Int") = verifyTF(TwoFace.Double(2.0) - TwoFace.Int(us(1)), us(1.0))
  property("Unsafe Double - Safe Int") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Int(1), us(1.0))
  property("Unsafe Double - Unsafe Int") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Int(us(1)), us(1.0))
  property("Safe Double - Safe Long") = verifyTF(TwoFace.Double(2.0) - TwoFace.Long(1L), 1.0)
  property("Safe Double - Unsafe Long") = verifyTF(TwoFace.Double(2.0) - TwoFace.Long(us(1L)), us(1.0))
  property("Unsafe Double - Safe Long") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Long(1L), us(1.0))
  property("Unsafe Double - Unsafe Long") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Long(us(1L)), us(1.0))
  property("Safe Double - Safe Float") = verifyTF(TwoFace.Double(2.0) - TwoFace.Float(1.0f), 1.0)
  property("Safe Double - Unsafe Float") = verifyTF(TwoFace.Double(2.0) - TwoFace.Float(us(1.0f)), us(1.0))
  property("Unsafe Double - Safe Float") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Float(1.0f), us(1.0))
  property("Unsafe Double - Unsafe Float") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Float(us(1.0f)), us(1.0))
  property("Safe Double - Safe Double") = verifyTF(TwoFace.Double(2.0) - TwoFace.Double(1.0), 1.0)
  property("Safe Double - Unsafe Double") = verifyTF(TwoFace.Double(2.0) - TwoFace.Double(us(1.0)), us(1.0))
  property("Unsafe Double - Safe Double") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Double(1.0), us(1.0))
  property("Unsafe Double - Unsafe Double") = verifyTF(TwoFace.Double(us(2.0)) - TwoFace.Double(us(1.0)), us(1.0))

  property("Safe Double * Safe Char") = verifyTF(TwoFace.Double(2.0) * TwoFace.Char('\u0001'), 2.0)
  property("Safe Double * Unsafe Char") = verifyTF(TwoFace.Double(2.0) * TwoFace.Char(us('\u0001')), us(2.0))
  property("Unsafe Double * Safe Char") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Char('\u0001'), us(2.0))
  property("Unsafe Double * Unsafe Char") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Char(us('\u0001')), us(2.0))
  property("Safe Double * Safe Int") = verifyTF(TwoFace.Double(2.0) * TwoFace.Int(1), 2.0)
  property("Safe Double * Unsafe Int") = verifyTF(TwoFace.Double(2.0) * TwoFace.Int(us(1)), us(2.0))
  property("Unsafe Double * Safe Int") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Int(1), us(2.0))
  property("Unsafe Double * Unsafe Int") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Int(us(1)), us(2.0))
  property("Safe Double * Safe Long") = verifyTF(TwoFace.Double(2.0) * TwoFace.Long(1L), 2.0)
  property("Safe Double * Unsafe Long") = verifyTF(TwoFace.Double(2.0) * TwoFace.Long(us(1L)), us(2.0))
  property("Unsafe Double * Safe Long") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Long(1L), us(2.0))
  property("Unsafe Double * Unsafe Long") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Long(us(1L)), us(2.0))
  property("Safe Double * Safe Float") = verifyTF(TwoFace.Double(2.0) * TwoFace.Float(1.0f), 2.0)
  property("Safe Double * Unsafe Float") = verifyTF(TwoFace.Double(2.0) * TwoFace.Float(us(1.0f)), us(2.0))
  property("Unsafe Double * Safe Float") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Float(1.0f), us(2.0))
  property("Unsafe Double * Unsafe Float") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Float(us(1.0f)), us(2.0))
  property("Safe Double * Safe Double") = verifyTF(TwoFace.Double(2.0) * TwoFace.Double(1.0), 2.0)
  property("Safe Double * Unsafe Double") = verifyTF(TwoFace.Double(2.0) * TwoFace.Double(us(1.0)), us(2.0))
  property("Unsafe Double * Safe Double") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Double(1.0), us(2.0))
  property("Unsafe Double * Unsafe Double") = verifyTF(TwoFace.Double(us(2.0)) * TwoFace.Double(us(1.0)), us(2.0))

  property("Safe Double / Safe Char") = verifyTF(TwoFace.Double(6.0) / TwoFace.Char('\u0002'), 3.0)
  property("Safe Double / Unsafe Char") = verifyTF(TwoFace.Double(6.0) / TwoFace.Char(us('\u0002')), us(3.0))
  property("Unsafe Double / Safe Char") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Char('\u0002'), us(3.0))
  property("Unsafe Double / Unsafe Char") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Char(us('\u0002')), us(3.0))
  property("Safe Double / Safe Int") = verifyTF(TwoFace.Double(6.0) / TwoFace.Int(2), 3.0)
  property("Safe Double / Unsafe Int") = verifyTF(TwoFace.Double(6.0) / TwoFace.Int(us(2)), us(3.0))
  property("Unsafe Double / Safe Int") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Int(2), us(3.0))
  property("Unsafe Double / Unsafe Int") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Int(us(2)), us(3.0))
  property("Safe Double / Safe Long") = verifyTF(TwoFace.Double(6.0) / TwoFace.Long(2L), 3.0)
  property("Safe Double / Unsafe Long") = verifyTF(TwoFace.Double(6.0) / TwoFace.Long(us(2L)), us(3.0))
  property("Unsafe Double / Safe Long") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Long(2L), us(3.0))
  property("Unsafe Double / Unsafe Long") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Long(us(2L)), us(3.0))
  property("Safe Double / Safe Float") = verifyTF(TwoFace.Double(6.0) / TwoFace.Float(2.0f), 3.0)
  property("Safe Double / Unsafe Float") = verifyTF(TwoFace.Double(6.0) / TwoFace.Float(us(2.0f)), us(3.0))
  property("Unsafe Double / Safe Float") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Float(2.0f), us(3.0))
  property("Unsafe Double / Unsafe Float") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Float(us(2.0f)), us(3.0))
  property("Safe Double / Safe Double") = verifyTF(TwoFace.Double(6.0) / TwoFace.Double(2.0), 3.0)
  property("Safe Double / Unsafe Double") = verifyTF(TwoFace.Double(6.0) / TwoFace.Double(us(2.0)), us(3.0))
  property("Unsafe Double / Safe Double") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Double(2.0), us(3.0))
  property("Unsafe Double / Unsafe Double") = verifyTF(TwoFace.Double(us(6.0)) / TwoFace.Double(us(2.0)), us(3.0))

  property("Safe Double % Safe Char") = verifyTF(TwoFace.Double(7.0) % TwoFace.Char('\u0004'), 3.0)
  property("Safe Double % Unsafe Char") = verifyTF(TwoFace.Double(7.0) % TwoFace.Char(us('\u0004')), us(3.0))
  property("Unsafe Double % Safe Char") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Char('\u0004'), us(3.0))
  property("Unsafe Double % Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Char(us('\u0004')), us(3.0))
  property("Safe Double % Safe Int") = verifyTF(TwoFace.Double(7.0) % TwoFace.Int(4), 3.0)
  property("Safe Double % Unsafe Int") = verifyTF(TwoFace.Double(7.0) % TwoFace.Int(us(4)), us(3.0))
  property("Unsafe Double % Safe Int") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Int(4), us(3.0))
  property("Unsafe Double % Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Int(us(4)), us(3.0))
  property("Safe Double % Safe Long") = verifyTF(TwoFace.Double(7.0) % TwoFace.Long(4L), 3.0)
  property("Safe Double % Unsafe Long") = verifyTF(TwoFace.Double(7.0) % TwoFace.Long(us(4L)), us(3.0))
  property("Unsafe Double % Safe Long") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Long(4L), us(3.0))
  property("Unsafe Double % Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Long(us(4L)), us(3.0))
  property("Safe Double % Safe Float") = verifyTF(TwoFace.Double(7.0) % TwoFace.Float(4.0f), 3.0)
  property("Safe Double % Unsafe Float") = verifyTF(TwoFace.Double(7.0) % TwoFace.Float(us(4.0f)), us(3.0))
  property("Unsafe Double % Safe Float") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Float(4.0f), us(3.0))
  property("Unsafe Double % Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Float(us(4.0f)), us(3.0))
  property("Safe Double % Safe Double") = verifyTF(TwoFace.Double(7.0) % TwoFace.Double(4.0), 3.0)
  property("Safe Double % Unsafe Double") = verifyTF(TwoFace.Double(7.0) % TwoFace.Double(us(4.0)), us(3.0))
  property("Unsafe Double % Safe Double") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Double(4.0), us(3.0))
  property("Unsafe Double % Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) % TwoFace.Double(us(4.0)), us(3.0))

  property("Safe Double < Safe Char") = verifyTF(TwoFace.Double(7.0) < TwoFace.Char('\u0004'), false)
  property("Safe Double < Unsafe Char") = verifyTF(TwoFace.Double(7.0) < TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Double < Safe Char") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Char('\u0004'), us(false))
  property("Unsafe Double < Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Char(us('\u0004')), us(false))
  property("Safe Double < Safe Int") = verifyTF(TwoFace.Double(7.0) < TwoFace.Int(4), false)
  property("Safe Double < Unsafe Int") = verifyTF(TwoFace.Double(7.0) < TwoFace.Int(us(4)), us(false))
  property("Unsafe Double < Safe Int") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Int(4), us(false))
  property("Unsafe Double < Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Int(us(4)), us(false))
  property("Safe Double < Safe Long") = verifyTF(TwoFace.Double(7.0) < TwoFace.Long(4L), false)
  property("Safe Double < Unsafe Long") = verifyTF(TwoFace.Double(7.0) < TwoFace.Long(us(4L)), us(false))
  property("Unsafe Double < Safe Long") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Long(4L), us(false))
  property("Unsafe Double < Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Long(us(4L)), us(false))
  property("Safe Double < Safe Float") = verifyTF(TwoFace.Double(7.0) < TwoFace.Float(4.0f), false)
  property("Safe Double < Unsafe Float") = verifyTF(TwoFace.Double(7.0) < TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Double < Safe Float") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Float(4.0f), us(false))
  property("Unsafe Double < Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Float(us(4.0f)), us(false))
  property("Safe Double < Safe Double") = verifyTF(TwoFace.Double(7.0) < TwoFace.Double(4.0), false)
  property("Safe Double < Unsafe Double") = verifyTF(TwoFace.Double(7.0) < TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Double < Safe Double") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Double(4.0), us(false))
  property("Unsafe Double < Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) < TwoFace.Double(us(4.0)), us(false))

  property("Safe Double > Safe Char") = verifyTF(TwoFace.Double(7.0) > TwoFace.Char('\u0004'), true)
  property("Safe Double > Unsafe Char") = verifyTF(TwoFace.Double(7.0) > TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Double > Safe Char") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Char('\u0004'), us(true))
  property("Unsafe Double > Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Char(us('\u0004')), us(true))
  property("Safe Double > Safe Int") = verifyTF(TwoFace.Double(7.0) > TwoFace.Int(4), true)
  property("Safe Double > Unsafe Int") = verifyTF(TwoFace.Double(7.0) > TwoFace.Int(us(4)), us(true))
  property("Unsafe Double > Safe Int") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Int(4), us(true))
  property("Unsafe Double > Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Int(us(4)), us(true))
  property("Safe Double > Safe Long") = verifyTF(TwoFace.Double(7.0) > TwoFace.Long(4L), true)
  property("Safe Double > Unsafe Long") = verifyTF(TwoFace.Double(7.0) > TwoFace.Long(us(4L)), us(true))
  property("Unsafe Double > Safe Long") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Long(4L), us(true))
  property("Unsafe Double > Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Long(us(4L)), us(true))
  property("Safe Double > Safe Float") = verifyTF(TwoFace.Double(7.0) > TwoFace.Float(4.0f), true)
  property("Safe Double > Unsafe Float") = verifyTF(TwoFace.Double(7.0) > TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Double > Safe Float") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Float(4.0f), us(true))
  property("Unsafe Double > Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Float(us(4.0f)), us(true))
  property("Safe Double > Safe Double") = verifyTF(TwoFace.Double(7.0) > TwoFace.Double(4.0), true)
  property("Safe Double > Unsafe Double") = verifyTF(TwoFace.Double(7.0) > TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Double > Safe Double") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Double(4.0), us(true))
  property("Unsafe Double > Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) > TwoFace.Double(us(4.0)), us(true))

  property("Safe Double <= Safe Char") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Char('\u0004'), false)
  property("Safe Double <= Unsafe Char") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Char(us('\u0004')), us(false))
  property("Unsafe Double <= Safe Char") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Char('\u0004'), us(false))
  property("Unsafe Double <= Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Char(us('\u0004')), us(false))
  property("Safe Double <= Safe Int") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Int(4), false)
  property("Safe Double <= Unsafe Int") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Int(us(4)), us(false))
  property("Unsafe Double <= Safe Int") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Int(4), us(false))
  property("Unsafe Double <= Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Int(us(4)), us(false))
  property("Safe Double <= Safe Long") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Long(4L), false)
  property("Safe Double <= Unsafe Long") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Long(us(4L)), us(false))
  property("Unsafe Double <= Safe Long") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Long(4L), us(false))
  property("Unsafe Double <= Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Long(us(4L)), us(false))
  property("Safe Double <= Safe Float") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Float(4.0f), false)
  property("Safe Double <= Unsafe Float") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Float(us(4.0f)), us(false))
  property("Unsafe Double <= Safe Float") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Float(4.0f), us(false))
  property("Unsafe Double <= Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Float(us(4.0f)), us(false))
  property("Safe Double <= Safe Double") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Double(4.0), false)
  property("Safe Double <= Unsafe Double") = verifyTF(TwoFace.Double(7.0) <= TwoFace.Double(us(4.0)), us(false))
  property("Unsafe Double <= Safe Double") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Double(4.0), us(false))
  property("Unsafe Double <= Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) <= TwoFace.Double(us(4.0)), us(false))

  property("Safe Double >= Safe Char") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Char('\u0004'), true)
  property("Safe Double >= Unsafe Char") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Char(us('\u0004')), us(true))
  property("Unsafe Double >= Safe Char") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Char('\u0004'), us(true))
  property("Unsafe Double >= Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Char(us('\u0004')), us(true))
  property("Safe Double >= Safe Int") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Int(4), true)
  property("Safe Double >= Unsafe Int") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Int(us(4)), us(true))
  property("Unsafe Double >= Safe Int") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Int(4), us(true))
  property("Unsafe Double >= Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Int(us(4)), us(true))
  property("Safe Double >= Safe Long") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Long(4L), true)
  property("Safe Double >= Unsafe Long") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Long(us(4L)), us(true))
  property("Unsafe Double >= Safe Long") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Long(4L), us(true))
  property("Unsafe Double >= Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Long(us(4L)), us(true))
  property("Safe Double >= Safe Float") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Float(4.0f), true)
  property("Safe Double >= Unsafe Float") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Float(us(4.0f)), us(true))
  property("Unsafe Double >= Safe Float") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Float(4.0f), us(true))
  property("Unsafe Double >= Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Float(us(4.0f)), us(true))
  property("Safe Double >= Safe Double") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Double(4.0), true)
  property("Safe Double >= Unsafe Double") = verifyTF(TwoFace.Double(7.0) >= TwoFace.Double(us(4.0)), us(true))
  property("Unsafe Double >= Safe Double") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Double(4.0), us(true))
  property("Unsafe Double >= Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) >= TwoFace.Double(us(4.0)), us(true))

  property("Safe Double == Regular Safe Char") = verifyTF(TwoFace.Double(7.0) == ('\u0007'), true)
  property("Safe Double == Regular Unsafe Char") = verifyTF(TwoFace.Double(7.0) == (us('\u0007')), us(true))
  property("Unsafe Double == Regular Safe Char") = verifyTF(TwoFace.Double(us(7.0)) == ('\u0007'), us(true))
  property("Unsafe Double == Regular Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) == (us('\u0007')), us(true))
  property("Safe Double == Regular Safe Int") = verifyTF(TwoFace.Double(7.0) == (7), true)
  property("Safe Double == Regular Unsafe Int") = verifyTF(TwoFace.Double(7.0) == (us(7)), us(true))
  property("Unsafe Double == Regular Safe Int") = verifyTF(TwoFace.Double(us(7.0)) == (7), us(true))
  property("Unsafe Double == Regular Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) == (us(7)), us(true))
  property("Safe Double == Regular Safe Long") = verifyTF(TwoFace.Double(7.0) == (7L), true)
  property("Safe Double == Regular Unsafe Long") = verifyTF(TwoFace.Double(7.0) == (us(7L)), us(true))
  property("Unsafe Double == Regular Safe Long") = verifyTF(TwoFace.Double(us(7.0)) == (7L), us(true))
  property("Unsafe Double == Regular Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) == (us(7L)), us(true))
  property("Safe Double == Regular Safe Float") = verifyTF(TwoFace.Double(7.0) == (7.0f), true)
  property("Safe Double == Regular Unsafe Float") = verifyTF(TwoFace.Double(7.0) == (us(7.0f)), us(true))
  property("Unsafe Double == Regular Safe Float") = verifyTF(TwoFace.Double(us(7.0)) == (7.0f), us(true))
  property("Unsafe Double == Regular Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) == (us(7.0f)), us(true))
  property("Safe Double == Regular Safe Double") = verifyTF(TwoFace.Double(7.0) == (7.0), true)
  property("Safe Double == Regular Unsafe Double") = verifyTF(TwoFace.Double(7.0) == (us(7.0)), us(true))
  property("Unsafe Double == Regular Safe Double") = verifyTF(TwoFace.Double(us(7.0)) == (7.0), us(true))
  property("Unsafe Double == Regular Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) == (us(7.0)), us(true))

  property("Safe Double == Safe Char") = verifyTF(TwoFace.Double(7.0) == TwoFace.Char('\u0007'), true)
  property("Safe Double == Unsafe Char") = verifyTF(TwoFace.Double(7.0) == TwoFace.Char(us('\u0007')), us(true))
  property("Unsafe Double == Safe Char") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Char('\u0007'), us(true))
  property("Unsafe Double == Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Char(us('\u0007')), us(true))
  property("Safe Double == Safe Int") = verifyTF(TwoFace.Double(7.0) == TwoFace.Int(7), true)
  property("Safe Double == Unsafe Int") = verifyTF(TwoFace.Double(7.0) == TwoFace.Int(us(7)), us(true))
  property("Unsafe Double == Safe Int") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Int(7), us(true))
  property("Unsafe Double == Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Int(us(7)), us(true))
  property("Safe Double == Safe Long") = verifyTF(TwoFace.Double(7.0) == TwoFace.Long(7L), true)
  property("Safe Double == Unsafe Long") = verifyTF(TwoFace.Double(7.0) == TwoFace.Long(us(7L)), us(true))
  property("Unsafe Double == Safe Long") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Long(7L), us(true))
  property("Unsafe Double == Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Long(us(7L)), us(true))
  property("Safe Double == Safe Float") = verifyTF(TwoFace.Double(7.0) == TwoFace.Float(7.0f), true)
  property("Safe Double == Unsafe Float") = verifyTF(TwoFace.Double(7.0) == TwoFace.Float(us(7.0f)), us(true))
  property("Unsafe Double == Safe Float") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Float(7.0f), us(true))
  property("Unsafe Double == Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Float(us(7.0f)), us(true))
  property("Safe Double == Safe Double") = verifyTF(TwoFace.Double(7.0) == TwoFace.Double(7.0), true)
  property("Safe Double == Unsafe Double") = verifyTF(TwoFace.Double(7.0) == TwoFace.Double(us(7.0)), us(true))
  property("Unsafe Double == Safe Double") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Double(7.0), us(true))
  property("Unsafe Double == Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) == TwoFace.Double(us(7.0)), us(true))

  property("Safe Double != Safe Char") = verifyTF(TwoFace.Double(7.0) != TwoFace.Char('\u0007'), false)
  property("Safe Double != Unsafe Char") = verifyTF(TwoFace.Double(7.0) != TwoFace.Char(us('\u0007')), us(false))
  property("Unsafe Double != Safe Char") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Char('\u0007'), us(false))
  property("Unsafe Double != Unsafe Char") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Char(us('\u0007')), us(false))
  property("Safe Double != Safe Int") = verifyTF(TwoFace.Double(7.0) != TwoFace.Int(7), false)
  property("Safe Double != Unsafe Int") = verifyTF(TwoFace.Double(7.0) != TwoFace.Int(us(7)), us(false))
  property("Unsafe Double != Safe Int") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Int(7), us(false))
  property("Unsafe Double != Unsafe Int") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Int(us(7)), us(false))
  property("Safe Double != Safe Long") = verifyTF(TwoFace.Double(7.0) != TwoFace.Long(7L), false)
  property("Safe Double != Unsafe Long") = verifyTF(TwoFace.Double(7.0) != TwoFace.Long(us(7L)), us(false))
  property("Unsafe Double != Safe Long") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Long(7L), us(false))
  property("Unsafe Double != Unsafe Long") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Long(us(7L)), us(false))
  property("Safe Double != Safe Float") = verifyTF(TwoFace.Double(7.0) != TwoFace.Float(7.0f), false)
  property("Safe Double != Unsafe Float") = verifyTF(TwoFace.Double(7.0) != TwoFace.Float(us(7.0f)), us(false))
  property("Unsafe Double != Safe Float") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Float(7.0f), us(false))
  property("Unsafe Double != Unsafe Float") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Float(us(7.0f)), us(false))
  property("Safe Double != Safe Double") = verifyTF(TwoFace.Double(7.0) != TwoFace.Double(7.0), false)
  property("Safe Double != Unsafe Double") = verifyTF(TwoFace.Double(7.0) != TwoFace.Double(us(7.0)), us(false))
  property("Unsafe Double != Safe Double") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Double(7.0), us(false))
  property("Unsafe Double != Unsafe Double") = verifyTF(TwoFace.Double(us(7.0)) != TwoFace.Double(us(7.0)), us(false))

  property("Safe Double min Safe Double") = verifyTF(TwoFace.Double(2.0) min TwoFace.Double(1.0), 1.0)
  property("Safe Double min Unsafe Double") = verifyTF(TwoFace.Double(2.0) min TwoFace.Double(us(1.0)), us(1.0))
  property("Unsafe Double min Safe Double") = verifyTF(TwoFace.Double(us(2.0)) min TwoFace.Double(1.0), us(1.0))
  property("Unsafe Double min Unsafe Double") = verifyTF(TwoFace.Double(us(2.0)) min TwoFace.Double(us(1.0)), us(1.0))

  property("Safe Double max Safe Double") = verifyTF(TwoFace.Double(2.0) max TwoFace.Double(1.0), 2.0)
  property("Safe Double max Unsafe Double") = verifyTF(TwoFace.Double(2.0) max TwoFace.Double(us(1.0)), us(2.0))
  property("Unsafe Double max Safe Double") = verifyTF(TwoFace.Double(us(2.0)) max TwoFace.Double(1.0), us(2.0))
  property("Unsafe Double max Unsafe Double") = verifyTF(TwoFace.Double(us(2.0)) max TwoFace.Double(us(1.0)), us(2.0))

  property("Safe Negate") = verifyTF(-TwoFace.Double(-1.0), 1.0)
  property("Unsafe Negate") = verifyTF(-TwoFace.Double(us(1.0)), us(-1.0))

  property("Safe toChar") = verifyTF(TwoFace.Double(1.0).toChar, '\u0001')
  property("Unsafe toChar") = verifyTF(TwoFace.Double(us(1.0)).toChar, us('\u0001'))
  property("Safe toInt") = verifyTF(TwoFace.Double(1.0).toInt, 1)
  property("Unsafe toInt") = verifyTF(TwoFace.Double(us(1.0)).toInt, us(1))
  property("Safe toLong") = verifyTF(TwoFace.Double(1.0).toLong, 1L)
  property("Unsafe toLong") = verifyTF(TwoFace.Double(us(1.0)).toLong, us(1L))
  property("Safe toFloat") = verifyTF(TwoFace.Double(1.0).toFloat, 1.0f)
  property("Unsafe toFloat") = verifyTF(TwoFace.Double(us(1.0)).toFloat, us(1.0f))
  property("Safe toString") = verifyTF(TwoFace.Double(1.0).toString, "1.0")
  property("Unsafe toString") = verifyTF(TwoFace.Double(us(1.0)).toString, us("1.0"))

  property("Safe abs") = verifyTF(abs(TwoFace.Double(-1.0)), 1.0)
  property("Unsafe abs") = verifyTF(abs(TwoFace.Double(us(-1.0))), us(1.0))

  property("Safe sin") = verifyTF(sin(TwoFace.Double(1.0)), 0.8414709848078965)
  property("Unsafe sin") = verifyTF(sin(TwoFace.Double(us(1.0))), us(0.8414709848078965))
  property("Safe cos") = verifyTF(cos(TwoFace.Double(1.0)), 0.5403023058681398)
  property("Unsafe cos") = verifyTF(cos(TwoFace.Double(us(1.0))), us(0.5403023058681398))
  property("Safe tan") = verifyTF(tan(TwoFace.Double(1.0)), 1.5574077246549023)
  property("Unsafe tan") = verifyTF(tan(TwoFace.Double(us(1.0))), us(1.5574077246549023))
  property("Safe ceil") = verifyTF(ceil(TwoFace.Double(1.5)), 2.0)
  property("Unsafe ceil") = verifyTF(ceil(TwoFace.Double(us(1.5))), us(2.0))
  property("Safe floor") = verifyTF(floor(TwoFace.Double(1.5)), 1.0)
  property("Unsafe floor") = verifyTF(floor(TwoFace.Double(us(1.5))), us(1.0))
  property("Safe round") = verifyTF(round(TwoFace.Double(1.5)), 2L)
  property("Unsafe round") = verifyTF(round(TwoFace.Double(us(1.5))), us(2L))
  property("Safe sqrt") = verifyTF(sqrt(TwoFace.Double(9.0)), 3.0)
  property("Unsafe sqrt") = verifyTF(sqrt(TwoFace.Double(us(9.0))), us(3.0))
  property("Safe log") = verifyTF(log(TwoFace.Double(9.0)), 2.1972245773362196)
  property("Unsafe log") = verifyTF(log(TwoFace.Double(us(9.0))), us(2.1972245773362196))
  property("Safe log10") = verifyTF(log10(TwoFace.Double(9.0)), 0.9542425094393249)
  property("Unsafe log10") = verifyTF(log10(TwoFace.Double(us(9.0))), us(0.9542425094393249))

  property("Safe Double pow Safe Float") = verifyTF(pow(TwoFace.Double(2.0), TwoFace.Float(3.0f)), 8.0)
  property("Safe Double pow Unsafe Float") = verifyTF(pow(TwoFace.Double(2.0), TwoFace.Float(us(3.0f))), us(8.0))
  property("Unsafe Double pow Safe Float") = verifyTF(pow(TwoFace.Double(us(2.0)), TwoFace.Float(3.0f)), us(8.0))
  property("Unsafe Double pow Unsafe Float") = verifyTF(pow(TwoFace.Double(us(2.0)), TwoFace.Float(us(3.0f))), us(8.0))
  property("Safe Double pow Safe Double") = verifyTF(pow(TwoFace.Double(2.0), TwoFace.Double(3.0)), 8.0)
  property("Safe Double pow Unsafe Double") = verifyTF(pow(TwoFace.Double(2.0), TwoFace.Double(us(3.0))), us(8.0))
  property("Unsafe Double pow Safe Double") = verifyTF(pow(TwoFace.Double(us(2.0)), TwoFace.Double(3.0)), us(8.0))
  property("Unsafe Double pow Unsafe Double") = verifyTF(pow(TwoFace.Double(us(2.0)), TwoFace.Double(us(3.0))), us(8.0))

  property("Implicit Conversions") = wellTyped {
    import singleton.ops._
    val a : TwoFace.Double[3.0] = implicitly[TwoFace.Double[2.0 + 1.0]]
    val b : TwoFace.Double[3.0 + 0.0] = implicitly[TwoFace.Double[2.0 + 1.0]]
    val c : TwoFace.Double[3.0 + 0.0] = implicitly[TwoFace.Double[3.0]]
    val d : 3.0 = TwoFace.Double(3.0)
    val e : Double = TwoFace.Double(us(3.0))
  }

  property("Wrong Implicit Conversions") = {
    import singleton.ops._
    illTyped("""val a : TwoFace.Double[3.0] = implicitly[TwoFace.Double[2.0 + 2.0]]""")
    illTyped("""val b : TwoFace.Double[3.0 + 0.0] = implicitly[TwoFace.Double[2.0 + 2.0]]""")
    illTyped("""val c : TwoFace.Double[3.0 + 0.0] = implicitly[TwoFace.Double[4.0]]""")
    true
  }

  property("ToString") = {
    TwoFace.Double[1.0].toString() == "1.0"
  }
}