━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Nstm
──────────────────────────────────────────────────
AUTHOR : Naoyuki Yoshinori（義則直行）


━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
このプログラムは、UMLのステートマシン図の状態遷移を実現するアプリケーションを作成します。
はじめに、アプリケーションの雛形を作成します。続いてステートマシンを作成し、このステートマシンを実装
します。状態遷移は StateMachineFramework が実現します。


インストール
──────────────────────────────────────────────────
    インストールしたディレクトリのパスを環境変数に設定します。
    set PATH=%PATH%;{path}\nstm-0.2.0\bin


はじめに
──────────────────────────────────────────────────
    `nstm new アプリケーション名`で、アプリケーションを作成します。
    $ nstm new MyApplication

    `nstm generate state-machine ステートマシン名`で、ステートマシンを作成します。
    $ cd ~/MyApplication
    $ nstm generate state-machine MyStateMachine

    `nstm create-factory [ファクトリー名]`で、ファクトリーを作成します。ファクトリーはステートマシンの
    インスタンの生成と破棄を管理します。ファクトリー名を省略した場合は、StateMachineFacotry が作成され
    ます。
    $ cd ~/MyApplication
    $ nstm create-factory MyFactory

    `nstm create-main start:ステートマシン名 [factory:ファクトリー名] [main:Main]`で、Main ファイルを作
    成します。
    $ cd ~/MyApplication
    $ nstm create-main start:MyStateMachine factory:MyFactory main:MyMain


Example
──────────────────────────────────────────────────
    状態[Start]から状態[End]に遷移するアプリケーションを作成するサンプルプログラム。

１．アプリケーションの作成とステートマシンの作成
    $ nstm new StmApp
    $ cd StmApp
    $ nstm g state-machine Start
    $ nstm g state-machine End
    $ nstm cf
    $ nstm cm start:Start

２．ステートマシン図の entry, do, event, exit にあたる部分を実装する。
    Start.h
    Start.cpp
    End.h
    End.cpp

    Start.cpp
------------------------------------------------------------------------------------------------
    void Start::doEvents(void)
    {
        if (ガード条件) {
            notifyNextStateMachineKey("End");
        }
    }

    End.cpp
------------------------------------------------------------------------------------------------
    void Start::doEvents(void)
    {
        if (ガード条件) {
            notifyChanged(true);
        }
    }

５．コンパイル
    $ cd ./src
    $ g++ -o StmApp.exe *.cpp

６．実行
    $ StmApp.exe

    実行順序
    1. Start#doEntries  開始時に１度だけ実行される。
    2. Start#doActions  notifyNextStateMachineKey また notifyChanged が呼ばれるまで実行される。
    3. Start#doEvents   次の遷移先を指定する場合は notifyNextStateMachineKey(key) を呼び出す。
                        次の遷移先がない場合は notifyChanged(true) を呼び出す。
    4. Start#doExits    終了時に１度だけ実行される。
    5. End#doEntries
    6. End#doActions
    7. End#doEvents
    8. End#doExits
