package connectfour.game.translations

class English: BaseTranslations() {
    init {
        translations["title"] = "Connect Four"
        translations["prompt_player_name_1"] = "First player's name:"
        translations["prompt_player_name_2"] = "Second player's name:"
        translations["board_size_title"] = "Set the board dimensions (Rows x Columns)"
        translations["prompt_board_size"] = "Press Enter for default ({defaultRows} x {defaultCols})"
        translations["invalid_board_size_row"] = "Board rows should be from {min} to {max}"
        translations["invalid_board_size_col"] = "Board columns should be from {min} to {max}"
        translations["invalid_board_size_input"] = "Invalid input"
        translations["question_number_of_games"] = "Do you want to play single or multiple games?"
        translations["hint_number_of_games"] = "For a single game, input 1 or press Enter"
        translations["prompt_number_of_games"] = "Input a number of games:"
        translations["invalid_number_of_games"] = "Invalid input"
        translations["single_game"] = "Single game"
        translations["total_games"] = "Total {number} games"
        translations["game_number"] = "Game #{number}"
        translations["players_info"] = "{name1} VS {name2}"
        translations["board_info"] = "{rows} X {cols} board"
        translations["prompt_player_turn"] = "{name}'s turn:"
        translations["column_out_of_range"] = "The column number is out of range ({left} - {right})"
        translations["invalid_column"] = "Incorrect column number"
        translations["column_is_full"] = "Column {column} is full"
        translations["player_won"] = "Player {name} won"
        translations["is_draw"] = "It is a draw"
        translations["score_title"] = "Score"
        translations["score"] = "{name}: {score}"
        translations["game_over"] = "Game Over!"
    }
}