package frc.team2506.robot.Subsystems

import com.revrobotics.CANSparkMax
import com.revrobotics.CANSparkMaxLowLevel
import edu.wpi.first.wpilibj.drive.MecanumDrive
import edu.wpi.first.wpilibj2.command.SubsystemBase
import frc.team2506.robot.Commands.DefaultDrive
import frc.team2506.robot.Constants

object Drivetrain : SubsystemBase(){

    // set up the left and right motor controllers for the drivetrain. assumed to be brushless motors (neos), change MotorType if not
    private val leftFrontSpark = CANSparkMax(Constants.LEFT_FRONT_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply {
        idleMode = CANSparkMax.IdleMode.kBrake
    }

    private val leftBackSpark = CANSparkMax(Constants.LEFT_BACK_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply {
        idleMode = CANSparkMax.IdleMode.kBrake
    }

    private val rightFrontSpark = CANSparkMax(Constants.RIGHT_FRONT_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply {
        idleMode = CANSparkMax.IdleMode.kBrake
    }

    private val rightBackSpark = CANSparkMax(Constants.RIGHT_BACK_SPARK_ID, CANSparkMaxLowLevel.MotorType.kBrushless).apply {
        idleMode = CANSparkMax.IdleMode.kBrake
    }

    val robotDrive = MecanumDrive(leftFrontSpark, leftBackSpark, rightFrontSpark, rightBackSpark)

    init{
        this.defaultCommand = DefaultDrive()
    }

    fun drive(xSpeed: Double, ySpeed: Double, rotation: Double){
        robotDrive.driveCartesian(xSpeed,ySpeed,rotation)
    }

}