package org.nstmframework

import org.nstmframework.command.Commands
import org.nstmframework.exception.NstmException
import org.nstmframework.exception.NstmErrorException

/**
 * User: Naoyuki Yoshinori
 */
class Nstm {

    static main(args) {
        try {

            new Commands(args: args).start()

        } catch (NstmException ex) {
            print """
USAGE: nstm [option...]

Example:
nstm new helloworld
cd helloworld
nstm generate state-machine Start
nstm generate state-machine End
nstm create-facotry
nsmt create-main start=Start

new                       アプリケーションの雛形を作成する。
g, generate               ステートマシンの雛形を作成する。
　　　          　　　　　state-machine [ステートマシン名]
                          entry-action  [ステートマシン名]
                          do-action     [ステートマシン名]
                          event-action  [ステートマシン名]
                          exit-action   [ステートマシン名]
cf, create-factory        StateMachineFacotry を作成する。
                          [ファクトリー名]
cm, create-main           Main を作成する。
                          start=[開始するステートマシン名]
                          main=[メイン名]
                          factory=[ファクトリー名]

"""
        } catch (NstmErrorException ex) {
            // TODO: 例外処理
        }
    }
}
