package frc.team2506.robot.Subsystems

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team2506.robot.Commands.Shoot
import frc.team2506.robot.Constants
import frc.team2506.robot.OI

object Shooter: SubsystemBase() {

    private val flywheelSpark = CANSparkMax(Constants.FLYWHEEL_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply{
        restoreFactoryDefaults()
        idleMode = CANSparkMax.IdleMode.kCoast
        setSmartCurrentLimit(30,1)
    }

    private val conveyorSpark = CANSparkMax(Constants.CONVEYOR_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply{
        restoreFactoryDefaults()
        idleMode = CANSparkMax.IdleMode.kCoast
    }

    var conveyorSpeed
        get() = conveyorSpark.appliedOutput
        set(value) = conveyorSpark.set(if (value>1)  1.0 else value)

    var flywheelSpeed
        get() = flywheelSpark.appliedOutput
        set(value) = conveyorSpark.set(if (value>1)  1.0 else value)

    var flywheelEnabled = false
        get() = field
        set(value) { field = value }

    init{

    }

}