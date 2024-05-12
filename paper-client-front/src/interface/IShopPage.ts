export interface IShopCategory {
    goodCategoryName: string,      // 目录title
    goodsCategoryId: number,     // 当前目录id
    categorySuperiorId: number, // 上级目录id
    children: IShopCategory[]
}

// 每个小分类的goodCategoryName
export type IShopItem = Pick<IShopCategory, 'goodCategoryName'>
