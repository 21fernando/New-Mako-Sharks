package frc.team2506.robot.Commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.team2506.robot.OI
import frc.team2506.robot.Subsystems.Drivetrain


class DefaultDrive: CommandBase() {

    init{
        addRequirements(Drivetrain)
    }

    override fun initialize() {

    }

    override fun execute() {
        Drivetrain.drive(OI.controllerX1*0.9, OI.controllerY1*0.9, OI.controllerX2*0.9)
    }

    override fun isFinished() = false
}