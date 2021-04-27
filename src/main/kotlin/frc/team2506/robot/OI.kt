package frc.team2506.robot
import edu.wpi.first.wpilibj2.command.button.Trigger
import frc.team2506.robot.Commands.Shoot
import java.util.function.BooleanSupplier


object OI {

    val xbox = edu.wpi.first.wpilibj.XboxController(Constants.JOSYSTICK_ID)
    val controllerX1: Double
        get() = value(xbox.getRawAxis(4))
    val controllerY1: Double
        get() = value(xbox.getRawAxis(5))
    val controllerX2: Double
        get() = value(xbox.getRawAxis(0))
    val shootTrigger  = Trigger(BooleanSupplier{xbox.getRawAxis(999) > 0.1}).apply {
        whenActive(Shoot())
    }

    fun value(v: Double): Double {
        var command = v
        command = when {
            command > Constants.DEADBAND -> (1 / (1 - Constants.DEADBAND)) * command - (Constants.DEADBAND / (1 - Constants.DEADBAND))
            command < -Constants.DEADBAND -> (1 / (1 - Constants.DEADBAND)) * command + (Constants.DEADBAND / (1 - Constants.DEADBAND))
            else -> 0.0
        }
        return command
    }

}