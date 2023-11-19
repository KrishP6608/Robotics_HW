
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ArcadeDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


Timer timer;
int moved;
public class moveTurn extends Command {
  Subsystem arcadedrive;

  public moveTrun(ArcadeDrive differential) {
    arcadedrive = differential;
    requires(Robot.arcadedrive);
    addRequirements(arcadedrive);
  }


  @Override
  protected void initialize() {
    timer = new Timer();
    timer.start();
    case = 0;
    
  }


  @Override
  protected void execute() {
    switch (moved){
      case 0:
            arcadedrive.arcadeDrive(1.0, 0);
            if (timer >= 10){
              moved++;
              arcadeDrive.arcadeDrive(0, 0);
            }
      case 1:
            while (ArcadeDrive.getAngle() != 90){
              arcadedrive.arcadeDrive(0, 0.5);
            }
            moved++;
      case 2:
            end();
            break;
    }
  }


  @Override
  protected boolean isFinished() {
    return false;
  }


  @Override
  protected void end() {
    arcadedrive.arcadeDrive(0, 0);
  }


  @Override
  protected void interrupted() {
  }
}
