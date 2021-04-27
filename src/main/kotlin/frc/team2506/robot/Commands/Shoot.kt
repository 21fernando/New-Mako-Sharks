package frc.team2506.robot.Commands

import edu.wpi.first.wpilibj2.command.CommandBase
import frc.team2506.robot.Subsystems.Shooter

class Shoot: CommandBase() {

    init{
        addRequirements(Shooter)
    }

    override fun initialize() {

    }

    override fun execute(){
        Shooter.flywheelEnabled = true;
        Shooter.conveyorSpeed = 0.6
        Shooter.flywheelSpeed = 0.7

    }

    override fun isFinished() = false
}