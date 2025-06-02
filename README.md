# QuickDoとは
このプロジェクトは、MVCアーキテクチャを採用したタスク管理システムです。ユーザーはタスクの登録、更新、削除、一覧表示ができ、ログイン機能を通じてセキュアに利用できます。

## 主な機能
### ユーザー認証
**1. サインイン機能:**  
登録済みのメールアドレスとパスワードの入力を行う。  
![サインイン画面](https://github.com/user-attachments/assets/2ffd7bd1-c540-4c13-952b-983b7f056081)

**2. サインアップ機能:**  
アカウントを新規登録します。名前、メールアドレス、パスワードはすべて必須となります。  
![サインアップ画面](https://github.com/user-attachments/assets/fb1bdb51-ac32-4734-8f16-a8b1bc653a7a)

**3. サインアウト機能:**  
タスク管理画面から **Sign Out** ボタン（青色）を押下し、サインアウトします。

### タスク管理
**1. Dashboard（タスク一覧表示）機能:**  
ログインユーザごとに登録済みタスクの一覧が表示されます。

✅ **登録例**
| タスク名  | 内容        | 期限        | 状態   | 優先度 | 担当者 |
|----------|------------|------------|--------|--------|--------|
| タスクA  | 仕様書作成  | 2025-06-10 | 進行中 | 高     | Kenzi  |
| タスクB  | コードレビュー | 2025-06-12 | 未着手 | 中     | Ken    |
| タスクC  | テスト実施  | 2025-06-15 | 完了   | 低     | Yuki   |

![Dashboard画面](https://github.com/user-attachments/assets/72f60e24-bff0-4f82-9fa5-d2739c6422db)

**2. タスクの登録:**  
タスク一覧表示画面上の **Add Task** ボタン（オレンジ色）をクリック。タスク登録モーダル画面から新規タスクを登録します。  
![タスク登録画面](https://github.com/user-attachments/assets/b2dc66dd-da36-468d-b223-cf0e6c8499af)

**3. タスクの更新・削除:**  
タスクの一覧表示画面から編集を行いたいタスクのセルをクリックすると、編集できます。  
![タスク編集画面](https://github.com/user-attachments/assets/e9915e05-4e63-4fb7-ab37-a7e034922f6b)

**4. データ管理:**  
データベースを利用した永続化。

## 技術スタック
- **バックエンド:** Java
- **フロントエンド:** HTML / CSS / JavaScript
- **データベース:** MySQL
- **その他:** Maven

## 環境構築手順
1. リポジトリをクローン:
   ```sh
   git clone https://github.com/example/task-management.git
2. データベースのセットアップ:
   ```sh
   docker-compose up -d
   ```
3. アプリケーションの起動:
   ```sh
   mvn spring-boot:run
   ```
4. `http://localhost:8080` にアクセスして動作確認

## 使用方法
1. ログインページで認証を行う。
2. タスクの作成 / 更新 / 削除を実施。
3. 一覧ページで登録済みのタスクを管理。

## 貢献方法
1. フォーク & クローン
2. ブランチ作成 (`git checkout -b feature-branch`)
3. コード変更 & コミット (`git commit -m "Add new feature"`)
4. プルリクエストを送信

## ライセンス
このプロジェクトは [MIT License](LICENSE) のもと提供されています。

## 作者
- **naonao96** - [GitHub](https://github.com/naonao96)
