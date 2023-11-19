
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Gyro;
import frc.robot.commands.raiseElevator;
import edu.wpi.first.wpilibj.command.Subsystem;

int targetAngle;
boolean raised;
int angle;
public class checkAngle extends Command {
  Subsystem elevator;
  Subsystem gyro;

  public checkAngle(Gyro gyro, Elevator elevator) {
    elevator = elevator;
    gyro = gyro;
    requires(elevator);
    requires(gyro);
    addRequirements(elevator);
    addRequirements(gyro);
  }


  @Override
  protected void initialize() {
    targetAngle = 90;
    angle = gyro.getAngle();
  }


  @Override
  protected void execute() {
    while (!raised){
        angle = gyro.getAngle();
        if (angle == targetAngle){
            raiseElevator(elevator);
            rasied = true;
        }
    }
  }

  @Override
  protected boolean isFinished() {
    return false;
  }


  @Override
  protected void end() {
    
  }


  @Override
  protected void interrupted() {
  }
}
